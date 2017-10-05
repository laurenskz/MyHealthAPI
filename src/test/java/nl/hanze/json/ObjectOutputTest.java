package nl.hanze.json;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Laurens on 3-10-2017.
 */
public class ObjectOutputTest {


    private static class POJO{
        int x = 2;
    }
    @Test
    public void write() throws Exception {
        MockOutput mockOutput = new MockOutput();
        try (ObjectOutput objectOutput = new ObjectOutput(mockOutput)) {
            objectOutput.write(new POJO());
            assertEquals(mockOutput.getLastReceived(),"{\"x\":2}");
        }
        assertTrue(mockOutput.closeIsCalled);
    }

    private static class MockOutput implements JsonDataOutput {
        private String lastReceived;
        private boolean closeIsCalled;

        @Override
        public void write(String json) {
            System.out.println(json);
            lastReceived = json;
        }

        @Override
        public void close() throws Exception {
            closeIsCalled = true;
        }

        public String getLastReceived() {
            return lastReceived;
        }

        public boolean isCloseIsCalled() {
            return closeIsCalled;
        }
    }


}