package com.habitrpg.client;

import com.habitrpg.client.resource.User;
import org.junit.Test;

import java.io.IOException;

public class NoFailTest {

    private String response = "{\"zap\": true, \"auth\":{\"local\":{\"username\":\"habitrpgjavaclient\",\"email\":\"julien.smadja@free.fr\",\"salt\":\"6b895b7c50\",\"hashed_password\":\"2cb1ba2930e438be2d3e144f91e5a77b7229c8a1\"},\"timestamps\":{\"created\":1374007028131,\"loggedin\":1374257064803}},\"balance\":0,\"dailyIds\":[],\"flags\":{\"ads\":\"show\",\"customizationsNotification\":true,\"dropsEnabled\":true,\"itemsEnabled\":true,\"partyEnabled\":true},\"habitIds\":[\"0513281a-9f71-49c3-9ad1-9a4247985f48\"],\"history\":{\"todos\":[{\"date\":1374092461554,\"value\":-8},{\"date\":1374257075687,\"value\":0}],\"exp\":[{\"date\":1374092461554,\"value\":-15},{\"date\":1374257075687,\"value\":2275.5}]},\"invitations\":{\"party\":null,\"guilds\":[]},\"items\":{\"armor\":\"2\",\"eggs\":[],\"hatchingPotions\":[],\"head\":\"1\",\"lastDrop\":{\"date\":1374256459196,\"count\":2},\"pets\":[\"TigerCub-Base\"],\"shield\":\"2\",\"weapon\":\"1\"},\"lastCron\":1374257075687,\"preferences\":{\"gender\":\"m\",\"skin\":\"white\",\"hair\":\"blond\",\"armorSet\":\"v1\",\"dayStart\":0,\"showHelm\":true},\"profile\":{\"blurb\":\"blurb\",\"imageUrl\":\"https://secure.gravatar.com/avatar/69ea701098399011a6b791d5971b22de?s=420&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png\",\"name\":\"name\",\"websites\":[\"http://www.web.com\"]},\"rewardIds\":[],\"stats\":{\"exp\":87.5,\"gp\":146.66644298477286,\"hp\":50,\"lvl\":13,\"toNextLevel\":310,\"maxHealth\":50},\"tags\":[{\"name\":\"morning\",\"id\":\"636d779a-f417-4c56-9f88-29a22f8dcf05\"},{\"name\":\"afternoon\",\"id\":\"3f60c9d3-478b-4e28-92f0-6fe7c82e31b8\"},{\"name\":\"evening\",\"id\":\"1b68fb50-2107-454b-a681-a3a241bdb7e8\"}],\"tasks\":{\"0513281a-9f71-49c3-9ad1-9a4247985f48\":{\"completed\":false,\"direction\":\"up\",\"down\":false,\"history\":[{\"date\":1374256459196,\"value\":1},{\"date\":1374256459547,\"value\":1.9747},{\"date\":1374256460200,\"value\":2.9253562257358428},{\"date\":1374256460993,\"value\":3.853133245658556},{\"date\":1374256462077,\"value\":4.759112700885761},{\"date\":1374256464021,\"value\":5.6443010177121415},{\"date\":1374256465814,\"value\":6.5096362419810205},{\"date\":1374256467434,\"value\":7.355994112832055},{\"date\":1374256468685,\"value\":8.184193475367},{\"date\":1374256469640,\"value\":8.995001116880612},{\"date\":1374256472097,\"value\":9.789136098905757},{\"date\":1374256476898,\"value\":10.567273646958993},{\"date\":1374256477492,\"value\":11.330048651176607},{\"date\":1374256477845,\"value\":12.07805882370548},{\"date\":1374256485751,\"value\":12.811867552519566},{\"date\":1374256490560,\"value\":13.53200648607811},{\"date\":1374256493479,\"value\":14.23897787876845},{\"date\":1374256495628,\"value\":14.933256723256155},{\"date\":1374256497804,\"value\":15.615292692592663},{\"date\":1374256498978,\"value\":16.28551191211884},{\"date\":1374256499709,\"value\":16.94431857878008},{\"date\":1374256500307,\"value\":17.59209644337522},{\"date\":1374256503498,\"value\":18.229210169447946}],\"id\":\"0513281a-9f71-49c3-9ad1-9a4247985f48\",\"notes\":\"notes\",\"priority\":\"!!!\",\"repeat\":null,\"streak\":0,\"tags\":null,\"text\":\"my task\",\"type\":\"habit\",\"up\":false,\"value\":9.114605084723973}},\"todoIds\":[],\"id\":\"3de939f9-b0c0-4668-ac1c-f5a02abfe6aa\"}";

    @Test
    public void should_not_fail_if_property_is_not_mapped() throws IOException {
        Configuration configuration = new Configuration();
        configuration.setFailOnUnknownProperties(false);
        RestClient restClient = new RestClient(configuration);
        restClient.unmarshall(response, User.class);
    }

    @Test(expected = IllegalStateException.class)
    public void should_fail_if_property_is_not_mapped() throws IOException {
        Configuration configuration = new Configuration();
        configuration.setFailOnUnknownProperties(true);
        RestClient restClient = new RestClient(configuration);
        restClient.unmarshall(response, User.class);
    }

}
