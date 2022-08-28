package online.flowerinsnow.xmlreader.core.node;

import online.flowerinsnow.xmlreader.api.node.XMLNode;
import online.flowerinsnow.xmlreader.api.node.XMLNodeType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

public class WrappedXMLNode implements XMLNode {
    private final Node wrapped;

    public WrappedXMLNode(Node wrapped) {
        this.wrapped = wrapped;
    }

    public Node getWrapped() {
        return wrapped;
    }

    @Override
    public @NotNull String getName() {
        return wrapped.getNodeName();
    }

    @Override
    public @NotNull String getValue() {
        return wrapped.getFirstChild().getNodeValue();
    }

    @Override
    public byte getValueAsByte() throws NumberFormatException {
        return Byte.parseByte(getValue());
    }

    @Override
    public short getValueAsShort() throws NumberFormatException {
        return Short.parseShort(getValue());
    }

    @Override
    public int getValueAsInt() throws NumberFormatException {
        return Integer.parseInt(getValue());
    }

    @Override
    public long getValueAsLong() throws NumberFormatException {
        return Long.parseLong(getValue());
    }

    @Override
    public boolean getValueAsBool() {
        return Boolean.parseBoolean(getValue());
    }

    @Override
    public float getValueAsFloat() throws NumberFormatException {
        return Float.parseFloat(getValue());
    }

    @Override
    public double getValueAsDouble() throws NumberFormatException {
        return Double.parseDouble(getValue());
    }

    @Override
    public @NotNull XMLNode setValue(@Nullable Object value) {
        wrapped.getFirstChild().setNodeValue(String.valueOf(value));
        return this;
    }

    @Override
    public @NotNull XMLNodeType getType() {
        return XMLNodeType.getByID(wrapped.getNodeType());
    }

    @Override
    public @NotNull Map<String, XMLNode> getChildNodes() {
        Map<String, XMLNode> nodes = new HashMap<>();
        NodeList childs = wrapped.getChildNodes();
        for (int i = 0; i < childs.getLength(); i++) {
            WrappedXMLNode node = new WrappedXMLNode(childs.item(i));
            nodes.put(node.getName(), node);
        }
        return nodes;
    }
}
