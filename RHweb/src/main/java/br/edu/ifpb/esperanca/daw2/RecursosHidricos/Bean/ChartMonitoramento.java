package br.edu.ifpb.esperanca.daw2.RecursosHidricos.Bean;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.json.JSONObject;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;



@Named
@RequestScoped
public class ChartMonitoramento implements Serializable {
     
    private LineChartModel lineModel;
     
    @PostConstruct
    public void init() {
        createLineModel();
    }
    
    public void createLineModel() {
    	String firebase_baseUrl = "https://sistema-de-irrigacao-90764.firebaseio.com/";

    	List<Number> values = new ArrayList<>();
    	
		Firebase firebase;
		try {
			firebase = new Firebase(firebase_baseUrl);
			FirebaseResponse firebaseResponse = firebase.get();
			String rawBody = firebaseResponse.getRawBody();
//			Scanner sc = new Scanner(rawBody);
//			sc.next("//");
//			StringTokenizer token = new StringTokenizer(rawBody);
//			while(token.hasMoreTokens()) {
//				String valor = token.nextToken("//");
//				values.add(valor);
//			}
			JSONObject j = new JSONObject(rawBody);
			Object object = j.get("dados");
			System.out.println(rawBody);
		} catch (FirebaseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	
    	
    	
        lineModel = new LineChartModel();
        ChartData data = new ChartData();
         
        LineChartDataSet dataSet = new LineChartDataSet();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);
         
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
         
        //Options
        LineChartOptions options = new LineChartOptions();        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        options.setTitle(title);
         
        lineModel.setOptions(options);
        lineModel.setData(data);
    }
    
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public LineChartModel getLineModel() {
        return lineModel;
    }
 
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
    
    public static void main(String[] args) {
    	JSONObject j = new JSONObject("{\"dados\":{\"-LvQMtBVdvjZN5wRjfLv\":\"DATA: 10:21:42 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQMvhioWiawFpiWAec\":\"DATA: 10:21:54 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQMyEI2D7A_wcuGXIU\":\"DATA: 10:22:4 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQN-nBw8hGDr85aTDx\":\"DATA: 10:22:14 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQN2Q0lAHrjbwKZmD5\":\"DATA: 10:22:25 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQN4x9_ardHDShl7M_\":\"DATA: 10:22:35 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQN7TOYjElCqwQ40e6\":\"DATA: 10:22:46 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQN9zswbmSKBLeLGcj\":\"DATA: 10:22:56 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNCWHjerTDaOI2xEG\":\"DATA: 10:23:6 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNF1TIIighlpHTqha\":\"DATA: 10:23:17 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNHZHGWEkn2abMXJa\":\"DATA: 10:23:27 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNK4bSWZV35mK_tT2\":\"DATA: 10:23:37 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNMbCEjetevr5pWWx\":\"DATA: 10:23:48 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNP7e4sx6f-rEsP-1\":\"DATA: 10:23:58 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNRdpA11gZEyeuNb4\":\"DATA: 10:24:8 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNUA4BW_J-vNInoE6\":\"DATA: 10:24:19 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNWg3QdILxy8jLYbh\":\"DATA: 10:24:29 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNZC8W9fLgUn8ghBk\":\"DATA: 10:24:39 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNaj1KVLqvdT0uoLB\":\"DATA: 10:24:50 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNdFJaFXX2Dl7boos\":\"DATA: 10:25:0 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNfme1q0B2TwBHfdh\":\"DATA: 10:25:10 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNiJ4x-ec-SeoeXDk\":\"DATA: 10:25:21 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNkpIwBcu05Ao0Pcd\":\"DATA: 10:25:31 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNnMHq2AOYFtQwye9\":\"DATA: 10:25:41 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNptTJNIiRi_oSpWG\":\"DATA: 10:25:52 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNsQxDD_Nh5ZQBG5S\":\"DATA: 10:26:2 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNuxGS3FnQD75Rxm1\":\"DATA: 10:26:13 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQNxTdb4wN87-qZyL6\":\"DATA: 10:26:23 - 6/12/2019 //  UMIDADE: 0.00\",\"-LvQO7AUhGVZPKNSEMTc\":\"DATA: 10:27:7 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQO9m0pya1rI0Xb8pB\":\"DATA: 10:27:17 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOCO4Iy4Zt80CBdqz\":\"DATA: 10:27:28 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOEyGL49UGXdInxVq\":\"DATA: 10:27:39 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOHYm5_hmgl8r7rqq\":\"DATA: 10:27:49 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOK9JhqncM78puok_\":\"DATA: 10:28:0 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOMm09WHVC_bVVvDe\":\"DATA: 10:28:11 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOPR1OpGettojs4Is\":\"DATA: 10:28:22 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOS15I3zj-j_71GWZ\":\"DATA: 10:28:32 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOUdQC8iJye2U3HhL\":\"DATA: 10:28:43 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOXEPCeHGYiNkOtjq\":\"DATA: 10:28:53 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOZphAMpR6M0sKI5b\":\"DATA: 10:29:4 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/minVAZÃO TOTAL: L\",\"-LvQOiVa_yDspPPdntdw\":\"DATA: 10:29:43 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQOlH0ELXOTWnKhf7K\":\"DATA: 10:29:54 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQOnrgp0ZJw27VVaWM\":\"DATA: 10:30:5 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQOqSPGGB-aiNX6Q1z\":\"DATA: 10:30:16 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQOt1vrMwxzEkBc3MY\":\"DATA: 10:30:26 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQOvflT9OR6Ju2MAoo\":\"DATA: 10:30:37 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQOyGH_7V2ArEVFwy8\":\"DATA: 10:30:48 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQP-r0QdiOoZLQa2W7\":\"DATA: 10:30:58 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQP2S0HdKm-7PaqTES\":\"DATA: 10:31:9 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQP5C8QvJC914p1hPu\":\"DATA: 10:31:19 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQP7qlDT4yztKo_jlF\":\"DATA: 10:31:31 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPARONLLL5BIq4wQg\":\"DATA: 10:31:42 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPD0yPNHX9OA6_lXS\":\"DATA: 10:31:52 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPFbeeUuT5P1__8qW\":\"DATA: 10:32:3 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPIBlyLRxXzISSgSe\":\"DATA: 10:32:13 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPKmTH2VdCg9XImN8\":\"DATA: 10:32:24 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPNRxhbcowcWV6omZ\":\"DATA: 10:32:35 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPQ0u0DyHZGBveJks\":\"DATA: 10:32:45 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPSbm2PNUT73rgRZr\":\"DATA: 10:32:56 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPVDDpv5wYgrV5COu\":\"DATA: 10:33:7 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPXocTBHHQoyCm3hN\":\"DATA: 10:33:17 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQP_PQVKxsyoZNfSEQ\":\"DATA: 10:33:28 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPc6xt4UZjaDSA4gS\":\"DATA: 10:33:39 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPehffyFluBef9cGI\":\"DATA: 10:33:50 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPhJXOVtnmq08NGSd\":\"DATA: 10:34:0 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPjuI4y1CQKFX4Scc\":\"DATA: 10:34:11 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPmW3BqIgd0C-iqEe\":\"DATA: 10:34:22 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPp6R2Mzv23pdSk8n\":\"DATA: 10:34:32 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPrsZm6wCbxj0iZ6i\":\"DATA: 10:34:44 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPueob1tUVL8q5QxG\":\"DATA: 10:34:55 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQPxIK_oSkGK9IdzYS\":\"DATA: 10:35:6 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQ-7PbQnCFdyR4oe1\":\"DATA: 10:35:18 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQ1lQnB5sbXi4h0HQ\":\"DATA: 10:35:28 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQ4N_KXBCafutYUUA\":\"DATA: 10:35:39 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQ6yPfjCFy9gh_fyx\":\"DATA: 10:35:50 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQ9l4KRqls8nHtCCf\":\"DATA: 10:36:1 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQCTNDdxn05yx3Ro3\":\"DATA: 10:36:12 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQF4-yHqw-U5klkGJ\":\"DATA: 10:36:23 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQHfHQjqh7DBSmGgK\":\"DATA: 10:36:34 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQKKILXQy6FGV8wDo\":\"DATA: 10:36:45 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQMvbF9siONpQxVQr\":\"DATA: 10:36:55 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQPWNB5BdYXdDhB0-\":\"DATA: 10:37:6 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQS6NKb6gL5ippFEJ\":\"DATA: 10:37:16 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQUomMRcUnsxyf19L\":\"DATA: 10:37:28 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQXWrv3qU7ShU0_en\":\"DATA: 10:37:39 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQ_6rG5dE9yQ-gc-F\":\"DATA: 10:37:49 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQbhixiMSSHbxsmvP\":\"DATA: 10:38:0 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQeIgOslbTLtbiYTI\":\"DATA: 10:38:10 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQgvWgxOq4oG1gf2K\":\"DATA: 10:38:21 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQj_xvrNkn0zUbh8v\":\"DATA: 10:38:32 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQnnLN0aKIG9M3teD\":\"DATA: 10:38:49 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQqPCimJlbgyoJ1AM\":\"DATA: 10:39:0 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQt1wXY-U2-pkeVGu\":\"DATA: 10:39:11 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQvdqdXgXVRrh9EWD\":\"DATA: 10:39:21 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQQyF5MubNMkkPXDWc\":\"DATA: 10:39:32 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQR-uxr1aMpo_FWFyj\":\"DATA: 10:39:43 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQR2WDNpw6uQKzq-LI\":\"DATA: 10:39:54 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQR56ZS4BC3HtRg-_W\":\"DATA: 10:40:4 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQR7i8gcrd4L80BXhR\":\"DATA: 10:40:15 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRAIxh-5P2H_abmRj\":\"DATA: 10:40:26 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRCuCMKcSk9i11oao\":\"DATA: 10:40:36 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRFVr0R7Ns9cgrKRa\":\"DATA: 10:40:47 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRI9QcM2XD5bFzYQT\":\"DATA: 10:40:58 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRKyylZZTO6NX-ABO\":\"DATA: 10:41:9 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRNcDMqqJ09TKZm16\":\"DATA: 10:41:20 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRQFbudAr0JzBlD8g\":\"DATA: 10:41:31 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRT2jKPOt1CinA_Pv\":\"DATA: 10:41:42 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRVh9mgylNkTbzeY9\":\"DATA: 10:41:53 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRYMAn2XcRWOw4vRt\":\"DATA: 10:42:4 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRaC4mMq91tcUrnH3\":\"DATA: 10:42:15 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRcnCbeU_xHKdFzSA\":\"DATA: 10:42:26 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRfOUH6m3fkYgtxFQ\":\"DATA: 10:42:37 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRhzR_jHXFjIJMY0J\":\"DATA: 10:42:48 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRka_NqaG3gYlSElf\":\"DATA: 10:42:58 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRnFegjE9-5mRwecK\":\"DATA: 10:43:9 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRppiVV0Ly1qyGreu\":\"DATA: 10:43:20 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRsQaINEtQsdJzZdC\":\"DATA: 10:43:30 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRv01vByhCm0SGL21\":\"DATA: 10:43:41 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQRxfn17uU9RfK20yz\":\"DATA: 10:43:52 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQS-GkjyPOucdiIBak\":\"DATA: 10:44:2 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQS1rUhqLJ7w8DRp2A\":\"DATA: 10:44:13 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQS4S2-zoRcYlXidHA\":\"DATA: 10:44:24 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQS72KltrdfS6UyQXl\":\"DATA: 10:44:34 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSADcx1TkSuicpFWA\":\"DATA: 10:44:47 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSCpFc087YI1Lhum3\":\"DATA: 10:44:58 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSFWuAojtsiuNPe2p\":\"DATA: 10:45:9 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSI75fheTwnxIt6Yp\":\"DATA: 10:45:20 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSKiDT9spAJ-rh8dN\":\"DATA: 10:45:30 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSNJeQtO_PnD1DaBU\":\"DATA: 10:45:41 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSPudyiMxKUGg2MMI\":\"DATA: 10:45:52 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSSVV0JOLneqlV8_n\":\"DATA: 10:46:2 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSV5F3_JFERBSHtep\":\"DATA: 10:46:13 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSXupq3WTwVZUdnxj\":\"DATA: 10:46:24 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQS_VsoWwsSFkawvbB\":\"DATA: 10:46:35 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSc8n-Fn0SvKiDM33\":\"DATA: 10:46:46 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSepHFuDKJZwnUmiY\":\"DATA: 10:46:57 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQShQMbU_yTQKKf-cy\":\"DATA: 10:47:7 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSk0Ys2JmR3YAwvp2\":\"DATA: 10:47:18 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSmbpYYo8guYZAlJJ\":\"DATA: 10:47:29 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSpCbBPWTX1Sh3RZp\":\"DATA: 10:47:39 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSvTTamUa23ak6rGG\":\"DATA: 10:48:4 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQSy8Zn-ZOjuOLQxKq\":\"DATA: 10:48:15 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQT-vERuY_FD_2PsVU\":\"DATA: 10:48:27 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQT2b1CUha_KsUk3_k\":\"DATA: 10:48:38 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQT5Ly26Z1xip-fCEM\":\"DATA: 10:48:49 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQT8-Y0tRRUK6pSDnv\":\"DATA: 10:49:0 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTAsKbOi8_6UxB0mT\":\"DATA: 10:49:11 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTDVuMgnCGgsaXNhV\":\"DATA: 10:49:22 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTG5pCkRFmJMRLgP_\":\"DATA: 10:49:33 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTIgOJzSR4qtzVDDI\":\"DATA: 10:49:43 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTLH1HWM6P2IMGBIT\":\"DATA: 10:49:54 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTNrH38xSU6hxpMFi\":\"DATA: 10:50:5 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTQS2JlK6up8-Vzs3\":\"DATA: 10:50:15 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTT2EiH2xVkbuHt6c\":\"DATA: 10:50:26 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTVcomAPT48jsqOks\":\"DATA: 10:50:37 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTYDPziTlwgKxJN-x\":\"DATA: 10:50:47 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQT_o3hUjwunleVJcg\":\"DATA: 10:50:58 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTcOD1oyt-5VCXKaH\":\"DATA: 10:51:8 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTezC7InIch8km5zi\":\"DATA: 10:51:19 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQThZHIPPjcwVfodpx\":\"DATA: 10:51:29 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTk8mX9G75WPW2KyK\":\"DATA: 10:51:40 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTmjd7EddVhkwFCS3\":\"DATA: 10:51:51 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTpKCEGWhuT-D7hOv\":\"DATA: 10:52:1 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTrurPeHH5BArdgZy\":\"DATA: 10:52:12 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTuVUzQjigSY8PbUx\":\"DATA: 10:52:22 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTx5pw_MW4nRdxEMs\":\"DATA: 10:52:33 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQTzgPTaO5VzFR0fTV\":\"DATA: 10:52:44 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\",\"-LvQU1I4RQXJaIudF3cr\":\"DATA: 10:52:54 - 6/12/2019 //  UMIDADE: 0.00//VAZÃO: L/min VAZÃO TOTAL: L\"}}");
    	JSONObject dados = (JSONObject) j.get("dados");
		for(String s :dados.keySet()) {
			Object object = dados.get(s);
			String o = object.toString();
			System.out.println(o.split("//")[0]);
		}
	}
}