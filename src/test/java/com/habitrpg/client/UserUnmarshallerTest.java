package com.habitrpg.client;

import com.habitrpg.client.resource.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class UserUnmarshallerTest {

    private ObjectMapper mapper = new ObjectMapper();

    private String response =
            "{" +
                    "\"auth\":{\"local\":{\"username\":\"habitrpgjavaclient\",\"email\":\"julien.smadja@free.fr\",\"salt\":\"6b895b7c50\",\"hashed_password\":\"2cb1ba2930e438be2d3e144f91e5a77b7229c8a1\"},\"timestamps\":{\"created\":1374007028131}}," +
                    "\"balance\":0," +
                    "\"dailyIds\":[" +
                    "\"e1bffbc1-6ae3-481e-b78b-353449b23cf2\"," +
                    "\"dfe4e31d-7d80-4c45-b4c1-e1b59b69a7b2\"," +
                    "\"fd10514f-b251-4949-9c4e-3f175e0287b9\"" +
                    "]," +
                    "\"flags\":{" +
                    "\"partyEnabled\":false," +
                    "\"itemsEnabled\":false," +
                    "\"ads\":\"show\"" +
                    "}," +
                    "\"habitIds\":[" +
                    "\"ef0e16ae-98d3-4b33-bca7-b60b509e9ae0\"," +
                    "\"2805e2a0-0eb3-4e1f-932d-3acb268af77d\"," +
                    "\"1d12c5a6-28f1-4a0b-a95d-8a3da65c325d\"" +
                    "]," +
                    "\"history\":{" +
                    "\"todos\":[" +
                    "{" +
                        "\"date\":1374092461554," +
                        "\"value\":-8" +
                    "}]," +
                    "\"exp\":[" +
                    "{" +
                        "\"date\":1374092461554," +
                        "\"value\":-15" +
                    "}]}" +
                    ","+
                    "\"invitations\":{" +
                    "\"party\":null," +
                    "\"guilds\":[]" +
                    "}," +
                    "\"items\":{" +
                    "\"armor\":0," +
                    "\"head\":0," +
                    "\"pets\":[]," +
                    "\"shield\":0," +
                    "\"weapon\":0" +
                    "}," +
                    "\"lastCron\":1373991887514," +
                    "\"preferences\":{" +
                    "\"gender\":\"m\"," +
                    "\"skin\":\"white\"," +
                    "\"hair\":\"blond\"," +
                    "\"armorSet\":\"v1\"," +
                    "\"dayStart\":0," +
                    "\"showHelm\":true" +
                    "}," +
                    "\"rewardIds\":[" +
                    "\"62d33cf5-decf-45b8-a281-928590a2bd25\"," +
                    "\"ca821462-b7c4-44f6-8cfe-2832f57e9453\"" +
                    "]," +
                    "\"stats\":{" +
                    "\"gp\":0," +
                    "\"exp\":0," +
                    "\"lvl\":1," +
                    "\"hp\":50," +
                    "\"toNextLevel\":150," +
                    "\"maxHealth\":50" +
                    "}," +
                    "\"tags\":[" +
                    "{" +
                    "\"name\":\"morning\"," +
                    "\"id\":\"5d733d92-7494-445c-9baf-409e00eef5a1\"" +
                    "}," +
                    "{" +
                    "\"name\":\"afternoon\"," +
                    "\"id\":\"6dc97b23-c113-4839-a4f4-f9e6e6ebcf21\"" +
                    "}," +
                    "{" +
                    "\"name\":\"evening\"," +
                    "\"id\":\"c99323f1-eb65-4dec-b84b-4de092008ddc\"" +
                    "}]," +
                    "\"tasks\":{" +
                    "\"ef0e16ae-98d3-4b33-bca7-b60b509e9ae0\":" +
                    "{" +
                    "\"type\":\"habit\"," +
                    "\"text\":\"1h Productive Work\"," +
                    "\"notes\":\"-- Habits: Constantly Track --\\nFor some habits, it only makes sense to *gain* points (like this one).\"," +
                    "\"value\":0," +
                    "\"up\":true," +
                    "\"down\":false," +
                    "\"id\":\"ef0e16ae-98d3-4b33-bca7-b60b509e9ae0\"" +
                    "}," +
                    "\"2805e2a0-0eb3-4e1f-932d-3acb268af77d\":" +
                    "{" +
                    "\"type\":\"habit\"," +
                    "\"text\":\"Eat Junk Food\"," +
                    "\"notes\":\"For others, it only makes sense to *lose* points\"," +
                    "\"value\":0," +
                    "\"up\":false," +
                    "\"down\":true," +
                    "\"id\":\"2805e2a0-0eb3-4e1f-932d-3acb268af77d\"" +
                    "}," +
                    "\"1d12c5a6-28f1-4a0b-a95d-8a3da65c325d\":" +
                    "{" +
                    "\"type\":\"habit\"," +
                    "\"text\":\"Take The Stairs\"," +
                    "\"notes\":\"For the rest, both + and - make sense (stairs = gain, elevator = lose)\"," +
                    "\"value\":0," +
                    "\"up\":true," +
                    "\"down\":true," +
                    "\"id\":\"1d12c5a6-28f1-4a0b-a95d-8a3da65c325d\"" +
                    "}," +
                    "\"e1bffbc1-6ae3-481e-b78b-353449b23cf2\":" +
                    "{" +
                    "\"type\":\"daily\"," +
                    "\"text\":\"1h Personal Project\"," +
                    "\"notes\":\"-- Dailies: Complete Once a Day --\\nAt the end of each day, non-completed Dailies dock you points.\"," +
                    "\"value\":0," +
                    "\"completed\":false," +
                    "\"repeat\":" +
                    "{" +
                    "\"m\":true," +
                    "\"t\":true," +
                    "\"w\":true," +
                    "\"th\":true," +
                    "\"f\":true," +
                    "\"s\":true," +
                    "\"su\":true" +
                    "}," +
                    "\"id\":\"e1bffbc1-6ae3-481e-b78b-353449b23cf2\"" +
                    "}," +
                    "\"dfe4e31d-7d80-4c45-b4c1-e1b59b69a7b2\":" +
                    "{" +
                    "\"type\":\"daily\"," +
                    "\"text\":\"Exercise\"," +
                    "\"notes\":\"If you are doing well, they turn green and are less valuable (experience, gold) and less damaging (HP). This means you can ease up on them for a bit.\"," +
                    "\"value\":3," +
                    "\"completed\":false," +
                    "\"repeat\":" +
                    "{" +
                    "\"m\":true," +
                    "\"t\":true," +
                    "\"w\":true," +
                    "\"th\":true," +
                    "\"f\":true," +
                    "\"s\":true," +
                    "\"su\":true" +
                    "}," +
                    "\"id\":\"dfe4e31d-7d80-4c45-b4c1-e1b59b69a7b2\"" +
                    "}," +
                    "\"fd10514f-b251-4949-9c4e-3f175e0287b9\":{" +
                    "\"type\":\"daily\"," +
                    "\"text\":\"45m Reading\"," +
                    "\"notes\":\"But if you are doing poorly, they turn red. The worse you do, the more valuable (exp, gold) and more damaging (HP) these goals become. This encourages you to focus on your shortcomings, the reds.\"," +
                    "\"value\":-10," +
                    "\"completed\":false," +
                    "\"repeat\":" +
                    "{" +
                    "\"m\":true," +
                    "\"t\":true," +
                    "\"w\":true," +
                    "\"th\":true," +
                    "\"f\":true," +
                    "\"s\":true," +
                    "\"su\":true" +
                    "}," +
                    "\"id\":\"fd10514f-b251-4949-9c4e-3f175e0287b9\"" +
                    "}," +
                    "\"bc8b6db0-2605-4943-bf18-114f628bb287\":{" +
                    "\"type\":\"todo\"," +
                    "\"text\":\"Call Mom\"," +
                    "\"notes\":\"-- Todos: Complete Eventually --\\nNon-completed Todos won't hurt you, but they will become more valuable over time. This will encourage you to wrap up stale Todos.\"" +
                    ",\"value\":-3," +
                    "\"completed\":false," +
                    "\"id\":\"bc8b6db0-2605-4943-bf18-114f628bb287\"" +
                    "}," +
                    "\"62d33cf5-decf-45b8-a281-928590a2bd25\":{" +
                    "\"type\":\"reward\"," +
                    "\"text\":\"1 Episode of Game of Thrones\"," +
                    "\"notes\":\"-- Rewards: Treat Yourself! --\\nAs you complete goals, you earn gold to buy rewards. Buy them liberally - rewards are integral in forming good habits.\"," +
                    "\"value\":20," +
                    "\"id\":\"62d33cf5-decf-45b8-a281-928590a2bd25\"" +
                    "}," +
                    "\"ca821462-b7c4-44f6-8cfe-2832f57e9453\":{" +
                    "\"type\":\"reward\"," +
                    "\"text\":\"Cake\"," +
                    "\"notes\":\"But only buy if you have enough gold - you lose HP otherwise.\"," +
                    "\"value\":10," +
                    "\"id\":\"ca821462-b7c4-44f6-8cfe-2832f57e9453\"" +
                    "}" +
                    "}," +
                    "\"todoIds\":[" +
                    "\"bc8b6db0-2605-4943-bf18-114f628bb287\"" +
                    "]," +
                    "\"id\":\"92db22e6-05e5-40e5-87ad-26531793e8da\"" +
                    "}";

    @Test
    public void should_unmarshall_auth() throws IOException {
        User user = mapper.readValue(response, User.class);
        Auth auth = user.getAuth();
        Local local = auth.getLocal();
        assertThat(local.getUsername()).isEqualTo("habitrpgjavaclient");
        assertThat(local.getEmail()).isEqualTo("julien.smadja@free.fr");
        assertThat(local.getSalt()).isEqualTo("6b895b7c50");
        assertThat(local.getHashedPassword()).isEqualTo("2cb1ba2930e438be2d3e144f91e5a77b7229c8a1");

        Timestamps timestamps = auth.getTimestamps();
        assertThat(timestamps.getCreated()).isEqualTo(1374007028131L);
    }

    @Test
    public void should_unmarshall_balance() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getBalance()).isEqualTo(0);
    }

    @Test
    public void should_unmarshall_daily_ids() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getDailyIds()).containsOnly("e1bffbc1-6ae3-481e-b78b-353449b23cf2", "dfe4e31d-7d80-4c45-b4c1-e1b59b69a7b2", "fd10514f-b251-4949-9c4e-3f175e0287b9");
    }

    @Test
    public void should_unmarshall_flags() throws IOException {
        User user = mapper.readValue(response, User.class);
        Flags flags = user.getFlags();
        assertThat(flags.getPartyEnabled()).isFalse();
        assertThat(flags.getItemsEnabled()).isFalse();
        assertThat(flags.getAds()).isEqualTo("show");
    }

    @Test
    public void should_unmarshall_habits_ids() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getHabitIds()).containsOnly("ef0e16ae-98d3-4b33-bca7-b60b509e9ae0", "2805e2a0-0eb3-4e1f-932d-3acb268af77d", "1d12c5a6-28f1-4a0b-a95d-8a3da65c325d");
    }

    @Test
    public void should_unmarshall_invitations() throws IOException {
        User user = mapper.readValue(response, User.class);
        Invitations invitations = user.getInvitations();
        assertThat(invitations.getParty()).isNull();
        assertThat(invitations.getGuilds()).isEmpty();
    }

    @Test
    public void should_unmarshall_items() throws IOException {
        User user = mapper.readValue(response, User.class);
        Items items = user.getItems();
        assertThat(items.getArmor()).isEqualTo(0);
        assertThat(items.getHead()).isEqualTo(0);
        assertThat(items.getPets()).isEmpty();
        assertThat(items.getShield()).isEqualTo(0);
        assertThat(items.getWeapon()).isEqualTo(0);
    }

    @Test
    public void should_unmarshall_last_cron() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getLastCron()).isEqualTo(1373991887514L);
    }

    @Test
    public void should_unmarshall_preferences() throws IOException {
        User user = mapper.readValue(response, User.class);
        Preferences preferences = user.getPreferences();
        assertThat(preferences.getGender()).isEqualTo(Preferences.Gender.m);
        assertThat(preferences.getSkin()).isEqualTo(Preferences.Skin.white);
        assertThat(preferences.getHair()).isEqualTo(Preferences.Hair.blond);
        assertThat(preferences.getArmorSet()).isEqualTo("v1");
        assertThat(preferences.getDayStart()).isEqualTo(0);
        assertThat(preferences.isShowHelm()).isTrue();
    }

    @Test
    public void should_unmarshall_reward_ids() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getRewardIds()).containsOnly("62d33cf5-decf-45b8-a281-928590a2bd25", "ca821462-b7c4-44f6-8cfe-2832f57e9453");
    }

    @Test
    public void should_unmarshall_stats() throws IOException {
        User user = mapper.readValue(response, User.class);
        Stats stats = user.getStats();
        assertThat(stats.getGp()).isEqualTo(0);
        assertThat(stats.getExp()).isEqualTo(0);
        assertThat(stats.getLvl()).isEqualTo(1);
        assertThat(stats.getHp()).isEqualTo(50);
        assertThat(stats.getToNextLevel()).isEqualTo(150);
        assertThat(stats.getMaxHealth()).isEqualTo(50);
    }

    @Test
    public void should_unmarshall_tags() throws IOException {
        User user = mapper.readValue(response, User.class);
        Collection<Tag> tags = user.getTags();
        assertThat(tags).hasSize(3);

        Tag tag = tags.iterator().next();
        assertThat(tag.getName()).isEqualTo("morning");
        assertThat(tag.getId()).isEqualTo("5d733d92-7494-445c-9baf-409e00eef5a1");
    }

    @Test
    public void should_unmarshall_tasks() throws IOException {
        User user = mapper.readValue(response, User.class);
        Map<String, Task> tasks = user.getTasks();
        assertThat(tasks).hasSize(9);

        Task task = tasks.get("e1bffbc1-6ae3-481e-b78b-353449b23cf2");
        assertThat(task.getType()).isEqualTo(Task.Type.daily);
        assertThat(task.isUp()).isFalse();
        assertThat(task.isDown()).isFalse();

        Repeat repeat = task.getRepeat();
        assertThat(repeat.isM()).isTrue();
        assertThat(repeat.isT()).isTrue();
        assertThat(repeat.isW()).isTrue();
        assertThat(repeat.isTh()).isTrue();
        assertThat(repeat.isF()).isTrue();
        assertThat(repeat.isS()).isTrue();
        assertThat(repeat.isSu()).isTrue();
    }

    @Test
    public void should_unmarshall_todo_ids() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getTodoIds()).containsOnly("bc8b6db0-2605-4943-bf18-114f628bb287");
    }

    @Test
    public void should_unmarshall_id() throws IOException {
        User user = mapper.readValue(response, User.class);
        assertThat(user.getId()).isEqualTo("92db22e6-05e5-40e5-87ad-26531793e8da");
    }

    @Test
    public void should_unmarshall_history() throws IOException {
        User user = mapper.readValue(response, User.class);
        History history = user.getHistory();

        Collection<Todo> todos = history.getTodos();
        Todo todo = todos.iterator().next();
        assertThat(todo.getDate()).isEqualTo(1374092461554L);
        assertThat(todo.getValue()).isEqualTo(-8);

        Collection<Exp> exp = history.getExp();
        Exp e = exp.iterator().next();
        assertThat(e.getDate()).isEqualTo(1374092461554L);
        assertThat(e.getValue()).isEqualTo(-15);
    }

}
