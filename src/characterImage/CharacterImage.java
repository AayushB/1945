package characterImage;

import imageFactory.*;
import java.util.HashMap;
import characterImage.DirectionalBulletImage.BulletDirection;

public abstract class CharacterImage
{
	//Hash Map for instances of children classes of DrawableImage
	public static HashMap<String, DrawableImage> image;
	private static String spriteSheetURL = "../img/spritesheet.png";
	private static String spriteSheetShadowURL="../img/spritesheet-shadow.png";
	static
	{
		image= new HashMap<String, DrawableImage>();
		
		image.put("BattleShip", new BattleShipImage(spriteSheetURL));
		image.put("BattleShipShadow", new BattleShipImage(spriteSheetShadowURL));
		
		image.put("BigExplosion", new BigExplosionImage(spriteSheetURL));
		image.put("BigExplosion", new SmallExplosionImage(spriteSheetURL));
		
		image.put("BigOrangeAirplane", new BigAirplaneImage(spriteSheetURL,1));//1 for orange 
		image.put("BigOrangeAirplaneShadow", new BigAirplaneImage(spriteSheetShadowURL,1));
		
		image.put("BigGreenAirplane", new BigAirplaneImage(spriteSheetURL,2)); // 2 for green
		image.put("BigGreenAirplaneShadow", new BigAirplaneImage(spriteSheetShadowURL,2));
		
		image.put("DirectionalBullet-E", new DirectionalBulletImage(spriteSheetURL, BulletDirection.E));
		image.put("DirectionalBullet-W", new DirectionalBulletImage(spriteSheetURL, BulletDirection.W));
		image.put("DirectionalBullet-NW", new DirectionalBulletImage(spriteSheetURL, BulletDirection.NW));
		image.put("DirectionalBullet-NE", new DirectionalBulletImage(spriteSheetURL, BulletDirection.NE));
		image.put("DirectionalBullet-SW", new DirectionalBulletImage(spriteSheetURL, BulletDirection.SW));
		image.put("DirectionalBullet-SE", new DirectionalBulletImage(spriteSheetURL, BulletDirection.SE));
		image.put("DoubleForwardBulletImage", new DoubleForwardBulletImage(spriteSheetURL));
		
		image.put("MiniAirplaneBlue", new MiniAirplaneImage(spriteSheetURL, PlaneColor.BLUE));
		image.put("MiniAirplaneGreen", new MiniAirplaneImage(spriteSheetURL, PlaneColor.GREEN));
		image.put("MiniAirplaneMilitary", new MiniAirplaneImage(spriteSheetURL, PlaneColor.MILITARY));
		image.put("MiniAirplaneWhite", new MiniAirplaneImage(spriteSheetURL, PlaneColor.WHITE));
		image.put("MiniAirplaneShadow", new MiniAirplaneImage(spriteSheetShadowURL, PlaneColor.BLUE));
		
		image.put("MiniAirplaneTurnBlue", new MiniAirplaneTurnImage(spriteSheetURL, PlaneColor.BLUE));
		image.put("MiniAirplaneTurnGreen", new MiniAirplaneTurnImage(spriteSheetURL, PlaneColor.GREEN));
		image.put("MiniAirplaneTurnMilitary", new MiniAirplaneTurnImage(spriteSheetURL, PlaneColor.MILITARY));
		image.put("MiniAirplaneTurnWhite", new MiniAirplaneTurnImage(spriteSheetURL, PlaneColor.WHITE));
		image.put("MiniAirplaneTurnShadow", new MiniAirplaneTurnImage(spriteSheetShadowURL, PlaneColor.BLUE));
		
		image.put("RedWhitePlane", new RedWhitePlaneImage(spriteSheetURL));
		image.put("RedWhitePlaneShadow", new RedWhitePlaneImage(spriteSheetShadowURL));

	}
}
