package com.thoughtworks.xstream.io.naming;

import com.thoughtworks.xstream.io.naming.StaticNameCoder;
import java.util.HashMap;
import junit.framework.TestCase;

public class StaticNameCoderTest extends TestCase {

  public void testDecodeAttribute() {
    final HashMap<String, String> node = new HashMap<>();
    final HashMap<String, String> attribute = new HashMap<>();
    StaticNameCoder staticNameCoder = new StaticNameCoder(node, attribute);
    assertEquals("non-existing attribute", staticNameCoder.decodeAttribute("non-existing attribute"));
 
    attribute.put("B", "C");
    staticNameCoder = new StaticNameCoder(node, attribute);
    assertEquals("B", staticNameCoder.decodeAttribute("C"));
  }

  public void testDecodeNode() {
    final HashMap<String, String> node = new HashMap<>();
    StaticNameCoder staticNameCoder = new StaticNameCoder(node, null);
    assertEquals("non-existing node", staticNameCoder.decodeNode("non-existing node"));
 
    node.put("B", "C");
    staticNameCoder = new StaticNameCoder(node, null);
    assertEquals("B", staticNameCoder.decodeNode("C"));
  }

  public void testEncodeAttribute() {
    final HashMap<String, String> node = new HashMap<>();
    final HashMap<String, String> attribute = new HashMap<>();
    StaticNameCoder staticNameCoder = new StaticNameCoder(node, attribute);
    assertEquals("non-existing attribute", staticNameCoder.encodeAttribute("non-existing attribute"));

    attribute.put("B", "C");
    staticNameCoder = new StaticNameCoder(node, attribute);
    assertEquals("C", staticNameCoder.encodeAttribute("B"));
  }

  public void testEncodeNode() {
    final HashMap<String, String> node = new HashMap<>();
    StaticNameCoder staticNameCoder = new StaticNameCoder(node, null);
    assertEquals("non-existing node", staticNameCoder.encodeNode("non-existing node"));

    node.put("B", "C");
    staticNameCoder = new StaticNameCoder(node, null);
    assertEquals("C", staticNameCoder.encodeNode("B"));
  }
}
