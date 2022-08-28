package online.flowerinsnow.xmlreader.api.node;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface XMLNode {
    @NotNull String getName();
    @NotNull String getValue();
    byte getValueAsByte() throws NumberFormatException;
    short getValueAsShort() throws NumberFormatException;
    int getValueAsInt() throws NumberFormatException;
    long getValueAsLong() throws NumberFormatException;
    boolean getValueAsBool();
    float getValueAsFloat() throws NumberFormatException;
    double getValueAsDouble() throws NumberFormatException;
    @NotNull XMLNode setValue(@Nullable Object value);
    @NotNull XMLNodeType getType();

    /**
     * 获取子节点
     *
     * @return K=节点名 V=节点
     */
    @NotNull Map<String, XMLNode> getChildNodes();
}
