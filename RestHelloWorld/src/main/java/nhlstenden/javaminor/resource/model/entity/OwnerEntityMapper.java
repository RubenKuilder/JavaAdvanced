package nhlstenden.javaminor.resource.model.entity;

import nhlstenden.javaminor.resource.model.domain.Owner;
import nhlstenden.javaminor.util.EntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerEntityMapper implements EntityMapper<OwnerEntity, Owner> {
    @Override
    public Owner mapFromEntity(OwnerEntity ownerEntity) {
        return new Owner(
                ownerEntity.getId(),
                ownerEntity.getPetEntities(),
                ownerEntity.getName(),
                ownerEntity.getAge(),
                ownerEntity.getCity()
        );
    }

    @Override
    public OwnerEntity mapToEntity(Owner owner) {
        return new OwnerEntity(
                owner.getName(),
                owner.getAge(),
                owner.getCity()
        );
    }

    public List<Owner> mapFromEntityList(List<OwnerEntity> entities) {
        List<Owner> myFinalList = new ArrayList<>();
        for (OwnerEntity entity : entities) {
            myFinalList.add(mapFromEntity(entity));
        }

        return myFinalList;
    }
}
