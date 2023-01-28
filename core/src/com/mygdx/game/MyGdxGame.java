package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;


public class MyGdxGame implements ApplicationListener {
    public Array<ModelInstance> instances = new Array<ModelInstance>();
    public Environment environment;
    public PerspectiveCamera cam;
    public CameraInputController camController;
    public ModelBatch modelBatch;
    public Model model;

    @Override
    public void create() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -0.3f, -1f, -0.6f));

        modelBatch = new ModelBatch();

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(10f, 10f, 10f);
        cam.lookAt(0, 0, 0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    buildSphere(2,2,2,MathUtils.random(15,30)*i,MathUtils.random(15,30)*j,MathUtils.random(15,30)*k,
                            MathUtils.random(0,180),MathUtils.random(0,1),MathUtils.random(0,1),MathUtils.random(0,1),
                            MathUtils.random(0f,1f),MathUtils.random(0f,1f),MathUtils.random(0f,1f));
                }
            }
        }

        camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);
    }

    public void buildKop(float x, float y, float z, float rotation,
                         float aX, float aY, float aZ){
        buildSphere(8,8,8,0+x,0+y,0+z,0+rotation,0+aX,0+aY,0+aZ,1f,0.5f,0.3f);

        buildSphere(3,2,2,0+x,-4+y,-1.5f+z,0+rotation,0+aX,0+aY,0+aZ,0.95f,0.45f,0.25f);
        buildSphere(3,2,2,0+x,-4+y,1.5f+z,0+rotation,0+aX,0+aY,0+aZ,0.95f,0.45f,0.25f);

        buildSphere(2,2,2,0+x,-0.5f+y,-4.5f+z,0+rotation,0+aX,0+aY,0+aZ,0.95f,0.45f,0.25f);
        buildSphere(2,2,2,0+x,-0.5f+y,4.5f+z,0+rotation,0+aX,0+aY,0+aZ,0.95f,0.45f,0.25f);

        buildSphere(1,1,1.5f,4+x,0.7f+y,0+z,0+rotation,0+aX,0+aY,0+aZ,0.5f,0.25f,0.1f);

        buildSphere(1,1.2f,1f,3.5f+x,1.5f+y,1f+z,0+rotation,0+aX,0+aY,0+aZ,1f,1f,1f);
        buildSphere(1,1.2f,1f,3.5f+x,1.5f+y,-1f+z,0+rotation,0+aX,0+aY,0+aZ,1f,1f,1f);

        buildSphere(0.2f,0.5f,0.4f,4f+x,1.5f+y,1f+z,0+rotation,0+aX,0+aY,0+aZ,0.2f,0.2f,0.2f);
        buildSphere(0.2f,0.5f,0.4f,4f+x,1.5f+y,-1f+z,0+rotation,0+aX,0+aY,0+aZ,0.2f,0.2f,0.2f);

        buildCylinder(5,0.25f,5,0+x,3.75f+y,0.2f+z,5+rotation,1+aX,0+aY,0+aZ,1f,0.8f,0f);
        buildCylinder(3,0.5f,3,0+x,4f+y,0.2f+z,5+rotation,1+aX,0+aY,0+aZ,0.9f,0.7f,0f);
    }

    public void buildTrain(float x, float y, float z, float rotation,
                           float aX, float aY, float aZ){

        buildBox(8,0.5f,3,0+x,0+y,0+z,0+rotation,0+aX,0+aY,0+aZ,0.9f,0.9f,0.9f);
        buildBox(8,0.5f,3,0+x,2.5f+y,0+z,0+rotation,0+aX,0+aY,0+aZ,0.9f,0.9f,0.9f);

        buildBox(0.5f,2,2,3.5f+x,1.25f+y,0f+z,0+rotation,0+aX,0+aY,0+aZ,0.7f,0.7f,0.7f);
        buildBox(0.5f,2,2,-3.5f+x,1.25f+y,0f+z,0+rotation,0+aX,0+aY,0+aZ,0.7f,0.7f,0.7f);

        buildBox(0.25f,0.5f,0.5f,4.125f+x,0+y,0f+z,0+rotation,0+aX,0+aY,0+aZ,0.7f,0.7f,0.7f);
        buildBox(0.25f,0.5f,0.5f,-4.125f+x,0+y,0f+z,0+rotation,0+aX,0+aY,0+aZ,0.7f,0.7f,0.7f);

        buildBox(8,2,0.5f,0+x,1.25f+y,1.25f+z,0+rotation,0+aX,0+aY,0+aZ,0.8f,0.8f,0.8f);
        buildBox(8,2,0.5f,0+x,1.25f+y,-1.25f+z,0+rotation,0+aX,0+aY,0+aZ,0.8f,0.8f,0.8f);

    }

    public void buildHouse1(float x, float y, float z, float rotation,
                            float aX, float aY, float aZ) {
        buildBox(10, 1, 10, 0+x, -0.5f+y, 0+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 1f, 1f, 1f);
        buildBox(10, 1, 10, 0+x, 4.5f+y, 0+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 1f, 1f, 1f);

        buildBox(1, 4, 7, -4.5f+x, 2+y, 1.5f+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 0.8f, 0.8f, 0.8f);
        buildBox(1, 4, 7, 4.5f+x, 2+y, 1.5f+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 0.8f, 0.8f, 0.8f);
        buildBox(9, 4, 1, 0+x, 2+y, 4.5f+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 0.8f, 0.8f, 0.8f);

        buildCylinder(2, 4, 2, -4+x, 2+y, -4+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 0.6f, 0.6f, 0.6f);
        buildCylinder(2, 4, 2, 4+x, 2+y, -4+z, 0+rotation, 0+aX, 0+aY, 0+aZ, 0.6f, 0.6f, 0.6f);
    }

    public void buildModel(float x, float y, float z, float rotation,
                           float aX, float aY, float aZ, String mdl){
        ModelBuilder modelBuilder = new ModelBuilder();
        model = new AssetManager().get(mdl, Model.class);
        ModelInstance instance = new ModelInstance(model);
        instance.transform.setToTranslation(x, y, z);
        instance.transform.rotate(aX, aY, aZ, rotation);
        instances.add(instance);
    }

    public void buildBox(float w, float h, float d, float x, float y, float z, float rotation,
                         float aX, float aY, float aZ, float r, float g, float b) {
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createBox(w, h, d,
                new Material(ColorAttribute.createDiffuse(new Color(r, g, b, 1))),
                Usage.Position | Usage.Normal);
        ModelInstance instance = new ModelInstance(model);
        instance.transform.setToTranslation(x, y, z);
        instance.transform.rotate(aX, aY, aZ, rotation);
        instances.add(instance);
    }

    public void buildSphere(float w, float h, float d, float x, float y, float z, float rotation,
                            float aX, float aY, float aZ, float r, float g, float b) {
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createSphere(w, h, d, 30, 30,
                new Material(ColorAttribute.createDiffuse(new Color(r, g, b, 1))),
                Usage.Position | Usage.Normal);
        ModelInstance instance = new ModelInstance(model);
        instance.transform.setToTranslation(x, y, z);
        instance.transform.rotate(aX, aY, aZ, rotation);
        instances.add(instance);
    }

    public void buildCylinder(float w, float h, float d, float x, float y, float z, float rotation,
                              float aX, float aY, float aZ, float r, float g, float b) {
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createCylinder(w, h, d, 50,
                new Material(ColorAttribute.createDiffuse(new Color(r, g, b, 1))),
                Usage.Position | Usage.Normal);
        ModelInstance instance = new ModelInstance(model);
        instance.transform.setToTranslation(x, y, z);
        instance.transform.rotate(aX, aY, aZ, rotation);
        instances.add(instance);
    }

    @Override
    public void render() {
        camController.update();

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(cam);
        modelBatch.render(instances, environment);
        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        instances.clear();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
