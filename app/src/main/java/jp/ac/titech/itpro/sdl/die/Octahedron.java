package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements Obj {

    private final static float[] VERTICES = {
            // overleft
            0, 1, 0,
            -1, 0, 0,
            0, 0, 1,
            // overfront
            0, 1, 0,
            0, 0, 1,
            1, 0, 0,
            // overright
            0, 1, 0,
            1, 0, 0,
            0, 0, -1,
            // overback
            0, 1, 0,
            0, 0, -1,
            -1, 0, 0,
            // underleft
            0, -1, 0,
            -1, 0, 0,
            0, 0, 1,
            // underfront
            0, -1, 0,
            1, 0, 0,
            0, 0, 1,
            // underright
            0, -1, 0,
            1, 0, 0,
            0, 0, -1,
            // underback
            0, -1, 0,
            -1, 0, 0,
            0, 0, -1
    };

    private final FloatBuffer vbuf;

    Octahedron() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // overleft
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // overfront
        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // overright
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // overback
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // underleft
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // underfront
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // underright
        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // underback
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }
}
