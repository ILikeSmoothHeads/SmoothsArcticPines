package smoothWC;


import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Variables {

	public static ArrayList<Node> jobs = new ArrayList<Node>();
	
	public static int arcticPine_ID = 70057;
	public static int articLogs_ID = 10810;
	public static int [] strongUrn_ID = {20316, 20310};
	public static int [] fullUrn_ID = {20318, 20312};
	public static int beaver_ID = 12021;
	public static int fire_ID = 70760;
	public static int seedNest_ID = 5073;
	public static int nest_ID = 5075;
	public static int [] dropSeed_IDs = {5312, 5313, 5283, 5284, 5285, 5286};
	public static int [] seed_IDs = {5314, 5288, 5287, 5315, 5289, 5316, 5290};
	public static int [] bridge_ID = {21307, 21306};
	public static int obelisk_ID = 29953;
	public static int summPoints;
	
	public static final Tile fireTile1 = new Tile(2328, 3828, 0);
	public static final Tile fireTile2 = new Tile(2330, 3828, 0); 
	public static final Tile fireTile3 = new Tile(2329, 3830, 0);
	public static final Tile fireTile4 = new Tile(2329, 3828, 0);
	public static final Area choppingArea = new Area(new Tile[] {new Tile(2335, 3830, 0), new Tile(2330, 3825, 0), new Tile(2324, 3829, 0), new Tile(2329, 3834, 0)});
	public static final Tile [] choppingTiles = {new Tile(2326, 3830, 0), new Tile(2327, 3830, 0), new Tile(2328, 3829, 0), new Tile(2327, 3827, 0), new Tile(2329, 3828, 0), new Tile(2330, 3828, 0)};
	public static final Tile bridgeTile1 = new Tile(2319,3831,0);
	public static final Tile bridgeTile2 = new Tile(2317,3822,0);
	public static final Tile obeliskTile = new Tile(2320,3810,0);
	public static final Area bridgeSide2 = new Area(new Tile[] {
			new Tile(2318, 3826, 0), new Tile(2313, 3826, 0),
			new Tile(2308, 3826, 0), new Tile(2307, 3821, 0),
			new Tile(2306, 3816, 0), new Tile(2305, 3811, 0),
			new Tile(2304, 3806, 0), new Tile(2303, 3801, 0),
			new Tile(2303, 3796, 0), new Tile(2306, 3792, 0),
			new Tile(2311, 3791, 0), new Tile(2316, 3789, 0),
			new Tile(2321, 3790, 0), new Tile(2325, 3793, 0),
			new Tile(2327, 3798, 0), new Tile(2329, 3803, 0),
			new Tile(2329, 3808, 0), new Tile(2329, 3813, 0),
			new Tile(2327, 3818, 0), new Tile(2324, 3822, 0),
			new Tile(2319, 3824, 0) 
	});
	
	public static int price0;
	public static int price1;
	public static int price2;
	public static int price3;
	public static int price4;
	public static int price5;
	public static int price6;
	public static int price7;
	
	public static int wcStartingXp;
	public static int wcGainedXp;
	public static int xpHour;
	public static int logsChopped;
	public static int startingLogs;
	public static int logsHour;
	public static long startTime;
	public static long currentTime;
	public static int urnsFilled;
	public static int startingUrns;
	public static int nestsLooted;
	public static int profit;
	public static int startingProfit;
	public static String status;
	
	public static boolean guiOpen = true;
	public static boolean beaver;
	public static boolean urns;
	public static boolean nests;
	public static boolean showPaint = true;
	
	public static WidgetChild teleButton = Widgets.get(1370, 12);
	public static WidgetChild actionBarButton = Widgets.get(640, 3);
	
	public static final Font font1 = new Font("Arial", Font.BOLD, 19);
	public static final Font font2 = new Font("Arial", Font.BOLD, 14);

	public static Image proggyImg = getImage("http://i.imgur.com/mdKfDIp.png");
	public static Image mouseImg = getImage("http://images3.wikia.nocookie.net/__cb20121110031047/runescape/images/0/0e/Dragon_hatchet.png");
	
	private static Image getImage(String url) {
        try { return ImageIO.read(new URL(url)); } 
        catch(IOException e) { return null; }
      }

}
