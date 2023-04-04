package com.example.demo4;
import java.awt.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private Hyperlink hyperlink;

    @FXML
    private HBox cardLayout;

    @FXML
    private HBox cardLayoout;


//    @Override
//    public void initialize(URL url, ResourceBundle resources) {
//        recentlyAdded = new ArrayList<>(recentlyAdded());
//        try{
//        for (int i = 0; i < recentlyAdded.size(); i++) {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
//            HBox cardBox = fxmlLoader.getController();
//            CardController cardController = fxmlLoader.getController();
//            cardController.setData(recentlyAdded.get(i));
//            cardLayoout.getChildren().add(cardBox);
//        }
//
//        }catch (Exception p){
//            System.out.println(p.getStackTrace());
//        }
//
//    }



    public void SwitchToSceneSport(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sport.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSceneBussiness(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bussiness.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSceneEconomy(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("economy.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSceneTech(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("technologies.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSceneContact(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("contacts.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToSigninScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openLinkTelegram(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://t.me/karakatalmasova"));

    }
    public void openLinkInstagram(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.instagram.com/almasovakarakat/"));

    }

    public void openLinkNews1(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.wsj.com/articles/low-jobless-claims-show-labor-market-shrugs-off-economys-clouds-dfb48962?mod=economy_lead_story"));

    }

    public void openLinkNews2(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.wsj.com/articles/janet-yellen-to-say-bank-rules-might-have-become-too-loose-2b7050c6?mod=economy_lead_pos1"));
    }
    public void openLinkNews3(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.wsj.com/articles/fed-treasury-fine-wells-fargo-for-sanctions-violations-ac5b06d4?mod=economy_lead_pos2"));
    }
    public void openLinkNews4(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.wsj.com/articles/exodus-from-americas-big-cities-slowed-last-year-as-pandemic-receded-d6ae7006?mod=economy_lead_pos4"));

    }
    public void openLinkNews5(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.wsj.com/articles/new-corporate-minimum-tax-could-ensnare-some-firms-over-one-time-moves-260f74df?mod=economy_lead_pos5"));

    }
    public void openLinkNews6(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.wsj.com/articles/a-rapid-finance-world-must-ready-for-a-slow-motion-banking-crisis-c80a2489?mod=economy_more_pos1"));

    }

    public void openLinkSport4(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/30/sport/sacramento-kings-nba-basketball-playoffs-spt-intl"));
    }
    public void openLinkSport5(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/30/sport/adam-peaty-swimming-mental-health-spt-scli-intl-gbr"));
    }
    public void openLinkSport6(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/30/sport/mlb-new-rules-explained-pitch-clock-spt-intl"));
    }
    public void openLinkSport1(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/29/football/james-mcclean-autism-diagnosis-intl-spt"));
    }
    public void openLinkSport2(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/24/sport/zane-robertson-doping-ban-suicidal-running-spt-intl"));
    }


    public void openLinkBuss1(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.bbc.com/news/business-65124741"));
    }
    public void openLinkBuss2(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.reuters.com/article/bmw-electric-batteries/bmw-bets-on-design-and-recycling-not-mining-to-lower-battery-costs-finance-chief-idUSKBN2VX093"));
    }
    public void openLinkBuss3(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.reuters.com/article/worldbank-asia/world-bank-raises-2023-growth-outlook-in-developing-east-asia-as-china-reopens-idUSKBN2VX03O"));
    }
    public void openLinkBuss4(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.reuters.com/article/imf-japan/imf-urges-boj-to-allow-longer-yields-to-move-more-flexibly-idUSKBN2VX03I"));
    }
    public void openLinkBuss5(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.reuters.com/article/usa-china-chips-japan/japan-to-restrict-chipmaking-equipment-exports-as-it-aligns-with-us-china-curbs-idUSKBN2VX03S"));
    }
    public void openLinkBuss6(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://www.reuters.com/article/global-oil/oil-down-marginally-amid-uncertainty-over-imminent-us-economic-data-idUSKBN2VX054"));
    }
    public void openLinkTec1(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/30/tech/ftc-openai-gpt-ai-think-tank"));
    }
    public void openLinkTec2(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/videos/tech/2023/03/24/ai-animal-translator-curiosity-daily-fj-contd-orig.cnn-business"));
    }
    public void openLinkTec3(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/24/tech/tiktok-douyin-bytedance-china-intl-hnk"));
    }
    public void openLinkTec4(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2023/03/24/tech/gordon-moore-obituary"));
    }
    public void openLinkTec5(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("Link is clicked");
        Desktop.getDesktop().browse(new URI("https://edition.cnn.com/2022/09/07/tech/apple-september-event-highlights-trends"));
    }
    public void openLinkTec6(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("https://edition.cnn.com/tech/live-news/apple-iphone-14-event");
        Desktop.getDesktop().browse(new URI(""));
    }
}


