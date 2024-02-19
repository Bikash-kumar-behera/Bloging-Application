package com.pns.spring;

import com.pns.spring.model.Head;
import com.pns.spring.model.Resp;
import com.pns.spring.model.RespOtp;
import com.pns.spring.model.Txn;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

//@SpringBootApplication
public class XmlApplication {

	public static void main(String[] args) {
//		SpringApplication.run(XmlApplication.class, args);

		RespOtp resp = prepareRespOtp();
		Marshaller marshaller = null;
		JAXBContext jaxbContext;	
		
		try {
			jaxbContext = JAXBContext.newInstance(RespOtp.class);
			marshaller = jaxbContext.createMarshaller();
			
//			XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
//			XMLStreamWriter xmlStreamWriter = outputFactory.createXMLStreamWriter(System.out);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(resp, System.out);
			System.out.flush();
		} catch (JAXBException e1) {
			System.out.println("JaxB  Error ========= ");
			e1.printStackTrace();
		}
	}

	public static RespOtp prepareRespOtp() {

		RespOtp respOtp = new RespOtp();
		Head head = new Head();
		head.setOrgId("174354");
		head.setVer("2.0");

		Txn txn = new Txn();
		txn.setId("74559485");
		txn.setRefId("egnt949");
		txn.setType("Otp");
		txn.setNote("reqOtp");
		
		Resp resp = new Resp();
		resp.setResult("Success");

		respOtp.setHead(head);
		respOtp.setTxn(txn);
		respOtp.setResp(resp);

		return respOtp;
	}

}
