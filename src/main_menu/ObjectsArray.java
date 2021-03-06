/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_menu;

import java.util.ArrayList;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Matrix4d;
import javax.vecmath.Point3d;

/**
 *
 * @author levan
 */
public class ObjectsArray {
    private ArrayList <Shape3D> Shapes;
    private int NoofShape;
    private int width;

    public ArrayList<Shape3D> getShapes() {
        return Shapes;
    }

    public void setShapes(ArrayList<Shape3D> Shapes) {
        this.Shapes = Shapes;
    }

    public int getNoofShape() {
        return NoofShape;
    }

    public void setNoofShape(int NoofShape) {
        this.NoofShape = NoofShape;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public Appearance getApp() {
        return app;
    }

    public void setApp(Appearance app) {
        this.app = app;
    }
    private int heigh;
    public Appearance app;
    ArrayList<String> list;

    public ObjectsArray(int width, int heigh, Appearance app, Canvas3D pc, BoundingSphere pbounds, BranchGroup pbg, TransformGroup ptrans,ArrayList <Shape3D> gShapes,ArrayList<String> list) {
        this(null, width, heigh, app,pc,pbounds, ptrans,gShapes, list);
        
    }

    public ObjectsArray(ArrayList<Shape3D> Shapes, int width, int heigh, Appearance app, Canvas3D pc, BoundingSphere pbounds, TransformGroup ptrans,ArrayList <Shape3D> gShapes,ArrayList<String> list) {
        this.Shapes = Shapes;
        this.width = width;
        this.list = list;
        this.heigh = heigh;
        this.app = app;
        this.Shapes = new ArrayList<>();
        
        
	double x=0.5 , z = -2.8, y = 0.0;
        
        if ( app == null )
	    {
		app = new Appearance( );
		Material material = new Material( );
		material.setDiffuseColor( new Color3f( 0.8f, 0.8f, 0.8f ) );
		material.setSpecularColor( new Color3f( 0.0f, 0.0f, 0.0f ) );
		material.setShininess( 0.0f );
		app.setMaterial( material );
	    }
        if (this.list.size() == 0){
//        for (int i= 0; i< this.width;i++){
//            x= -2.5;
//            
//            for (int j=0; j<this.heigh; j++){
//                Area area = new Area(this.app,x,y,z,"Tree", pc, pbounds, ptrans, gShapes);
//                
//                this.Shapes.add(area);
//                gShapes.add(area);
//                x= x+5;
//            }
//            z = z+5;
//
//        }
        }
        else{
            for (String str: list){
                String[] arr = str.split(", ");
                System.out.print(str);
                Matrix4d mtr = new Matrix4d( 
                Double.parseDouble(arr[0]),
                Double.parseDouble(arr[1]),
                Double.parseDouble(arr[2]),
                Double.parseDouble(arr[3]),
                Double.parseDouble(arr[4]),
                Double.parseDouble(arr[5]),
                Double.parseDouble(arr[6]),
                Double.parseDouble(arr[7]),
                Double.parseDouble(arr[8]),
                Double.parseDouble(arr[9]),
                Double.parseDouble(arr[10]),
                Double.parseDouble(arr[11]),
                Double.parseDouble(arr[12]),
                Double.parseDouble(arr[13]),
                Double.parseDouble(arr[14]),
                Double.parseDouble(arr[15]));
                Transform3D t3d = new Transform3D(mtr);
                Area area = new Area(this.app,t3d,arr[16], pc, pbounds, ptrans, gShapes);
                this.Shapes.add(area);
                gShapes.add(area);
            }
        }
                       
    }
    public void Apply(TransformGroup  bg,Canvas3D c, Bounds b){
        if (bg == null){
            bg = new TransformGroup ();
            bg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        }

        for (Shape3D shape : this.Shapes){
           bg.addChild(((Area)shape).getBg());
            BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
        1000.0);
      
//            PickHighlightBehavior pickBeh = new 
//            PickHighlightBehavior(c, ((Area)shape).getBg(),((Area)shape).t3d,((Area)shape).getTrans(), b, bg);
//            ((Area)shape).getBg().addChild(pickBeh);
            
            
           // PickTranslateBehavior translate = new PickTranslateBehavior(((Area)shape).getBg(), c, b);
            //((Area)shape).getBg().addChild(translate);
           // PickZoomBehavior zoom = new PickZoomBehavior(((Area)shape).getBg(), c, b);
           // ((Area)shape).getBg().addChild(zoom);
            
       //     CollisionDetector cd = new CollisionDetector();
        }
        
    }
}
