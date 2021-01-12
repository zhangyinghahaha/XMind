package tacos.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.model.TacoOrder;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Repository
//public class JdbcOrderRepository implements OrderRepository{
//    private JdbcTemplate jdbcTemplate;
//    @Override
//    public TacoOrder save(TacoOrder order) {
//        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
//                "insert into Taco_Order"
//                        + "(delivery_name, delivery_street, delivery_city, "
//                        + "delivery_state, delivery_zip, cc_number, "
//                        + "cc_expiration, cc_cvv, placed_at) "
//                        + "values (?,?,?,?,?,?,?,?,?)",
//                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
//        );
//        pscf.setReturnGeneratedKeys(true);
//        order.setPlacedAt(new Date());
//        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
//                Arrays.asList(
//                        order.getDeliveryName(),
//                        order.getDeliveryState(),
//                        order.getDeliveryCity(),
//                        order.getDeliveryState(),
//                        order.getDeliveryZip(),
//                        order.getCcNumber(),
//                        order.getCcExpiration(),
//                        order.getCcCVV(),
//                        order.getPlacedAt())
//        );
//        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(psc, keyHolder);
//        long orderId = keyHolder.getKey().longValue();
//        order.setId(orderId);
//
//        List<Taco> tacos = order.getTacos();
//        int i = 0;
//        for (Taco taco : tacos) {
//            saveTaco(orderId, i++, taco);
//        }
//
//        return order;
//    }
//
//    private long saveTaco(Long orderId, int orderKey, Taco taco) {
//        taco.setCreatedAt(new Date());
//        PreparedStatementCreatorFactory pscf =
//                new PreparedStatementCreatorFactory(
//                        "insert into Taco "
//                                + "(name, created_at, taco_order, taco_order_key) "
//                                + "values (?, ?, ?, ?)",
//                        Types.VARCHAR, Types.TIMESTAMP, Types.BIGINT, Types.BIGINT
//                );
//        pscf.setReturnGeneratedKeys(true);
//
//        PreparedStatementCreator psc =
//                pscf.newPreparedStatementCreator(
//                        Arrays.asList(
//                                taco.getName(),
//                                taco.getCreatedAt(),
//                                orderId,
//                                orderKey));
//
//        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(psc, keyHolder);
//        long tacoId = keyHolder.getKey().longValue();
//        taco.setId(tacoId);
//
//        saveIngredientRef(tacoId, taco.getIngredients());
//        return tacoId;
//    }
//
//    private void saveIngredientRef(long tacoId, List<String> ingredients) {
//        int key = 0;
//        for (String ingredient : ingredients) {
//            jdbcTemplate.update(
//                    "insert into Ingredient_Ref (ingredient, taco, taco_key) " + "values (?, ?, ?)",
//                    ingredient,
//                    tacoId,
//                    key++);
//        }
//    }
//}
