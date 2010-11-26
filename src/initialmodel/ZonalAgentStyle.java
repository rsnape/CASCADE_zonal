package initialmodel;

import java.awt.Color;

import repast.simphony.visualization.gis3D.GIS3DShapeFactory;
import repast.simphony.visualization.gis3D.Material;
import repast.simphony.visualization.gis3D.MaterialFactory;
import repast.simphony.visualization.gis3D.RenderableShape;
import repast.simphony.visualization.gis3D.style.StyleGIS3D;

/**
 * 
 * @author J Richard Snape
 *
 */
public class ZonalAgentStyle implements StyleGIS3D<ZonalAgent>{

	public RenderableShape getShape(ZonalAgent agent) {
		// Render as spheres	
		RenderableShape shape = GIS3DShapeFactory.createCone(10);//,1000,0,2);  


    return shape;		
	}

	public Material getMaterial(ZonalAgent agent, Material material) {
		Color color = null;
		double solar = agent.getMiso() + agent.getMaso();
    	float yellowness = (float) solar;
		//System.out.println(agent.toString() + " has yellowness " + yellowness);
    	if (yellowness < 0)
    		yellowness = 0;
    	
    	if (yellowness > 10)
    		yellowness = 10;
		color = new Color(yellowness/10,yellowness/10,1-(yellowness/10));
		material = new Material(color,color,color,color,0);
		return MaterialFactory.setMaterialAppearance(material, color);

	}

	public float[] getScale(ZonalAgent agent) {
		
		float [] scalefactors = new float[3];
		scalefactors[0] =  1f ; //1; //(float) (agent.getMiw() + agent.getMaw()) * 10f;
		scalefactors[1] = 1f ; //1; // (float) (agent.getMiw() + agent.getMaw()) * 10f;
		scalefactors[2] = (float) (agent.getMiw() + agent.getMaw()); // / 10;
		return scalefactors;
	}

	public boolean isScaled(ZonalAgent object) {
		return true;
	}
}