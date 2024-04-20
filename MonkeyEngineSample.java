import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Torus;
import com.jme3.system.AppSettings;

public class MonkeyEngineSample extends SimpleApplication {

    public static void main(String[] args) {
        MonkeyEngineSample app = new MonkeyEngineSample();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("My Awesome Game");
        app.setSettings(settings);
        app.start();
    }

    protected Geometry geom1, geom2, geom3, geom4;
    protected float time = 0f;

    @Override
    public void simpleInitApp() {
        // Torus
        Torus torus = new Torus(32, 32, 0.5f, 1f);
        geom4 = new Geometry("Torus", torus);
        geom4.setLocalTranslation(new Vector3f(3, -3, 3));
        Material matTorus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matTorus.setColor("Color", ColorRGBA.Red);
        geom4.setMaterial(matTorus);
        rootNode.attachChild(geom4);

        // Box
        Box box1 = new Box(1, 1, 1);
        geom1 = new Geometry("Box", box1);
        geom1.setLocalTranslation(new Vector3f(3, -1, 3));
        Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Blue);
        geom1.setMaterial(mat1);
        rootNode.attachChild(geom1);

        // Sphere
        Sphere sphere = new Sphere(32, 32, 1);
        geom2 = new Geometry("Sphere", sphere);
        geom2.setLocalTranslation(new Vector3f(-3, 0, 0));
        Material matSphere = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matSphere.setColor("Color", ColorRGBA.Green);
        geom2.setMaterial(matSphere);
        rootNode.attachChild(geom2);

        // Cylinder
        Cylinder cylinder = new Cylinder(32, 32, 1.5f, 3.0f, true); 
        geom3 = new Geometry("Cylinder", cylinder);
        geom3.setLocalTranslation(new Vector3f(-2, -2, -2));
        Material matCylinder = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matCylinder.setColor("Color", ColorRGBA.Cyan);
        geom3.setMaterial(matCylinder);
        rootNode.attachChild(geom3);
    }

    @Override
    public void simpleUpdate(float tpf) {
        time += tpf;

        // その場で y 軸周りに自転
        geom1.rotate(0, 2 * tpf, 0);

        // XY 平面に平行な平面上で円軌道上
        float radius = 2f;
        float speed = 1.5f;
        geom2.setLocalTranslation(new Vector3f(
                radius * FastMath.cos(time * speed),
                radius * FastMath.sin(time * speed),
                0
        ));

        // 0.5 倍 〜 1.5 倍の範囲で周期的に大きさを変える
        float scale = 1f + 0.5f * FastMath.sin(2*time);
        geom4.setLocalScale(scale);
    }
}