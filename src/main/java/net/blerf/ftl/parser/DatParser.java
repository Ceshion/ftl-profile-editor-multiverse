package net.blerf.ftl.parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.output.DOMOutputter;

import net.blerf.ftl.model.shiplayout.ShipLayout;
import net.blerf.ftl.model.shiplayout.ShipLayoutDoor;
import net.blerf.ftl.model.shiplayout.ShipLayoutRoom;
import net.blerf.ftl.parser.TextUtilities;
import net.blerf.ftl.xml.Achievement;
import net.blerf.ftl.xml.Achievements;
import net.blerf.ftl.xml.Animations;
import net.blerf.ftl.xml.BackgroundImageList;
import net.blerf.ftl.xml.BackgroundImageLists;
import net.blerf.ftl.xml.Blueprints;
import net.blerf.ftl.xml.CrewNameList;
import net.blerf.ftl.xml.CrewNameLists;
import net.blerf.ftl.xml.Encounters;
import net.blerf.ftl.xml.NamedText;
import net.blerf.ftl.xml.NamedTexts;
import net.blerf.ftl.xml.SectorData;
import net.blerf.ftl.xml.ShipBlueprint;
import net.blerf.ftl.xml.ShipChassis;
import net.blerf.ftl.xml.ShipEvent;
import net.blerf.ftl.xml.ShipEvents;
import net.blerf.ftl.xml.TextLookupUnmarshalListener;
import net.ceshion.ftl.xml.hyperspace.FTL;


public class DatParser {

	private Pattern xmlDeclPtn = Pattern.compile( "<[?]xml [^>]*?[?]>\n*" );
	private Pattern rootTagPtn = Pattern.compile( "</?FTL>\n*" );

	private Pattern scrubPtn = Pattern.compile( xmlDeclPtn.pattern() +"|"+ rootTagPtn.pattern() );


	public DatParser() {
	}


	public List<NamedText> readNamedTextList( InputStream stream, String fileName ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<namedTexts>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</nameTexts>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		JAXBContext jc = JAXBContext.newInstance( NamedTexts.class );
		Unmarshaller u = jc.createUnmarshaller();

		NamedTexts nts = (NamedTexts)u.unmarshal( domOutputter.output( doc ) );

		return nts.getNamedTexts();
	}

  public FTL readHyperspace( InputStream stream, String fileName, Map<String, String> textLookupMap ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<FTL>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</FTL>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		TextLookupUnmarshalListener textLookupListener = new TextLookupUnmarshalListener();
		textLookupListener.getLookupMap().putAll( textLookupMap );

		JAXBContext jc = JAXBContext.newInstance( FTL.class );
		Unmarshaller u = jc.createUnmarshaller();
		u.setListener( textLookupListener );

		FTL hs = (FTL)u.unmarshal( domOutputter.output( doc ) );

		return hs;
	}

	public List<Achievement> readAchievements( InputStream stream, String fileName, Map<String, String> textLookupMap ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<achievements>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</achievements>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		TextLookupUnmarshalListener textLookupListener = new TextLookupUnmarshalListener();
		textLookupListener.getLookupMap().putAll( textLookupMap );

		JAXBContext jc = JAXBContext.newInstance( Achievements.class );
		Unmarshaller u = jc.createUnmarshaller();
		u.setListener( textLookupListener );

		Achievements ach = (Achievements)u.unmarshal( domOutputter.output( doc ) );

		return ach.getAchievements();
	}


	public Blueprints readBlueprints( InputStream stream, String fileName, Map<String, String> textLookupMap ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<blueprints>" );
		streamBuf.append( streamText );
		streamBuf.append( "</blueprints>" );

		// Edit the buffer in place.
		// Note: The replacement will be inserted as-is, with no backreference substitution.

		Map<Pattern, String> fixMap = new LinkedHashMap<Pattern, String>();
		fixMap.put( xmlDeclPtn, "" );
		fixMap.put( rootTagPtn, "" );

		if ( "blueprints.xml".equals( fileName ) ) {
			// blueprints.xml: LONG_ELITE_MED shipBlueprint (FTL 1.03.1)
			// blueprints.xml: LONG_ELITE_HARD shipBlueprint (FTL 1.03.1)
			fixMap.put( Pattern.compile( " img=\"rebel_long_hard\"" ), " img=\"rebel_long_elite\"" );

			// blueprints.xml: SYSTEM_CASING augBlueprint (FTL 1.02.6)
			String casingRegex = ""
				+ "\\s*<title>Reinforced System Casing</title>"   // Two titles, scrub the first.
				+ "(?=\\s*<title>Titanium System Casing</title>)";
			fixMap.put( Pattern.compile( casingRegex ), "" );     // Used lookahead instead of group.
		}

		for ( Map.Entry<Pattern, String> entry : fixMap.entrySet() ) {
			Matcher m = entry.getKey().matcher( streamBuf );
			int start = 0;
			while ( m.find( start ) ) {
				streamBuf.replace( m.start(), m.end(), entry.getValue() );
				start = m.start() + entry.getValue().length();  // Continue searching after the replacement.
			}
		}

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		TextLookupUnmarshalListener textLookupListener = new TextLookupUnmarshalListener();
		textLookupListener.getLookupMap().putAll( textLookupMap );

		JAXBContext jc = JAXBContext.newInstance( Blueprints.class );
		Unmarshaller u = jc.createUnmarshaller();
		u.setListener( textLookupListener );

		Blueprints bps = (Blueprints)u.unmarshal( domOutputter.output( doc ) );

		return bps;
	}


	public ShipLayout readLayout( InputStream stream, String fileName ) throws IOException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;
		BufferedReader in = new BufferedReader( new StringReader( streamText ) );

		ShipLayout shipLayout = new ShipLayout();

		String line = null;
		boolean firstLine = true;
		boolean comment = false;

		while ( (line = in.readLine()) != null ) {
			if ( line.length() == 0 ) continue;

			if ( line.equals( "X_OFFSET" ) ) {
				shipLayout.setOffsetX( Integer.parseInt( in.readLine() ) );
			}
			else if ( line.equals( "Y_OFFSET" ) ) {
				shipLayout.setOffsetY( Integer.parseInt( in.readLine() ) );
			}
			else if ( line.equals( "HORIZONTAL" ) ) {
				shipLayout.setHorizontal( Integer.parseInt( in.readLine() ) );
			}
			else if ( line.equals( "VERTICAL" ) ) {
				shipLayout.setVertical( Integer.parseInt( in.readLine() ) );
			}
			else if ( line.equals( "ELLIPSE" ) ) {
				int w = Integer.parseInt( in.readLine() );
				int h = Integer.parseInt( in.readLine() );
				int x = Integer.parseInt( in.readLine() );
				int y = Integer.parseInt( in.readLine() );
				shipLayout.setShieldEllipse( w, h, x, y );
			}
			else if ( line.equals( "ROOM" ) ) {
				int roomId = Integer.parseInt( in.readLine() );
				int locationX = Integer.parseInt( in.readLine() );
				int locationY = Integer.parseInt( in.readLine() );
				int hSquares = Integer.parseInt( in.readLine() );
				int vSquares = Integer.parseInt( in.readLine() );
				ShipLayoutRoom layoutRoom = new ShipLayoutRoom( locationX, locationY, hSquares, vSquares );

				shipLayout.setRoom( roomId, layoutRoom );
			}
			else if ( line.equals( "DOOR" ) ) {
				int wallX = Integer.parseInt( in.readLine() );
				int wallY = Integer.parseInt( in.readLine() );
				int roomIdA = Integer.parseInt( in.readLine() );
				int roomIdB = Integer.parseInt( in.readLine() );
				int vertical = Integer.parseInt( in.readLine() );
				ShipLayoutDoor layoutDoor = new ShipLayoutDoor( roomIdA, roomIdB );

				shipLayout.setDoor( wallX, wallY, vertical, layoutDoor );
			}
		}
		return shipLayout;
	}


	public ShipChassis readChassis( InputStream stream, String fileName ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<shipChassis>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</shipChassis>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		JAXBContext jc = JAXBContext.newInstance( ShipChassis.class );
		Unmarshaller u = jc.createUnmarshaller();

		ShipChassis sch = (ShipChassis)u.unmarshal( domOutputter.output( doc ) );

		return sch;
	}

	public List<CrewNameList> readCrewNames( InputStream stream, String fileName ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<nameLists>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</nameLists>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		JAXBContext jc = JAXBContext.newInstance( CrewNameLists.class );
		Unmarshaller u = jc.createUnmarshaller();

		CrewNameLists cnl = (CrewNameLists)u.unmarshal( domOutputter.output( doc ) );

		return cnl.getCrewNameLists();
	}


	public SectorData readSectorData( InputStream stream, String fileName, Map<String, String> textLookupMap ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<sectorData>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</sectorData>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		TextLookupUnmarshalListener textLookupListener = new TextLookupUnmarshalListener();
		textLookupListener.getLookupMap().putAll( textLookupMap );

		JAXBContext jc = JAXBContext.newInstance( SectorData.class );
		Unmarshaller u = jc.createUnmarshaller();
		u.setListener( textLookupListener );

		SectorData sectorData = (SectorData)u.unmarshal( domOutputter.output( doc ) );

		return sectorData;
	}


	public Encounters readEvents( InputStream stream, String fileName, Map<String, String> textLookupMap ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<events>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</events>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		TextLookupUnmarshalListener textLookupListener = new TextLookupUnmarshalListener();
		textLookupListener.getLookupMap().putAll( textLookupMap );

		JAXBContext jc = JAXBContext.newInstance( Encounters.class );
		Unmarshaller u = jc.createUnmarshaller();
		u.setListener( textLookupListener );

		Encounters evts = (Encounters)u.unmarshal( domOutputter.output( doc ) );

		return evts;
	}


	public List<ShipEvent> readShipEvents( InputStream stream, String fileName, Map<String, String> textLookupMap ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<shipEvents>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</shipEvents>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		TextLookupUnmarshalListener textLookupListener = new TextLookupUnmarshalListener();
		textLookupListener.getLookupMap().putAll( textLookupMap );

		JAXBContext jc = JAXBContext.newInstance( ShipEvents.class );
		Unmarshaller u = jc.createUnmarshaller();
		u.setListener( textLookupListener );

		ShipEvents shvts = (ShipEvents)u.unmarshal( domOutputter.output( doc ) );

		return shvts.getShipEvents();
	}


	public List<BackgroundImageList> readImageLists( InputStream stream, String fileName ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<imageLists>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</imageLists>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		JAXBContext jc = JAXBContext.newInstance( BackgroundImageLists.class );
		Unmarshaller u = jc.createUnmarshaller();

		BackgroundImageLists imgs = (BackgroundImageLists)u.unmarshal( domOutputter.output( doc ) );

		return imgs.getImageLists();
	}


	public Animations readAnimations( InputStream stream, String fileName ) throws IOException, JAXBException, JDOMException {

		String streamText = TextUtilities.decodeText( stream, fileName ).text;

		StringBuffer streamBuf = new StringBuffer( streamText.length() + 50 );
		streamBuf.append( "<animations>" );
		Matcher m = scrubPtn.matcher( streamText );
		while ( m.find() ) {
			m.appendReplacement( streamBuf, "" );
		}
		m.appendTail( streamBuf );
		streamBuf.append( "</animations>" );

		Document doc = TextUtilities.parseStrictOrSloppyXML( streamBuf, fileName );
		DOMOutputter domOutputter = new DOMOutputter();

		JAXBContext jc = JAXBContext.newInstance( Animations.class );
		Unmarshaller u = jc.createUnmarshaller();

		Animations animations = (Animations)u.unmarshal( domOutputter.output( doc ) );

		return animations;
	}
}
