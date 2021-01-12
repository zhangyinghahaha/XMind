package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import tacos.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
