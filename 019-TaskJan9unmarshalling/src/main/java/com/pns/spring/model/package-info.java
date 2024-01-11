@jakarta.xml.bind.annotation.XmlSchema(
        namespace = "http://npci.org/upi/schema/",
        elementFormDefault = jakarta.xml.bind.annotation.XmlNsForm.UNQUALIFIED,//can be adjusted to accept data only with name-space prefix
        xmlns = {
            @jakarta.xml.bind.annotation.XmlNs(prefix = "upi", namespaceURI = "http://npci.org/upi/schema/")
        })

package com.pns.spring.model;