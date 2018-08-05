package pe.com.fe.adapter;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

@SuppressWarnings("unused")
public class JaxbCDATA {

	
	private static XMLSerializer getXMLSerializer() {
        // configure an OutputFormat to handle CDATA
        OutputFormat of = new OutputFormat();

        // specify which of your elements you want to be handled as CDATA.
        // The use of the '^' between the namespaceURI and the localname
        // seems to be an implementation detail of the xerces code.
	// When processing xml that doesn't use namespaces, simply omit the
	// namespace prefix as shown in the third CDataElement below.
        of.setCDataElements(
			    new String[] { "ns1^foo",   // <ns1:foo>
					   "ns2^bar",   // <ns2:bar>
					   "^baz" });   // <baz>

        // set any other options you'd like
        of.setPreserveSpace(true);
        of.setIndenting(true);

        // create the serializer
        XMLSerializer serializer = new XMLSerializer(of);
        serializer.setOutputByteStream(System.out);

        return serializer;
    }
	
}
