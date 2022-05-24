package springWebEx.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    //멀티 쓰레드 환경일 경우,
    //ConcurrentHashMap<>();을 사용하고,
    //AtomicInteger 를 사용해야 한다.
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static Long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        //사실은, update용 파라미터 3개를 따로 객체로 만드는 것이 맞다.
        //왜냐하면, id가 사용이 되지 않기 때문이다.
        //DTO를 만들어서 사용하는 것이 더 좋다.
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
