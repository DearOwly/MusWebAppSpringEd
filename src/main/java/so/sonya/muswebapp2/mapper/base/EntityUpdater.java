package so.sonya.muswebapp2.mapper.base;

import org.mapstruct.MappingTarget;

public interface EntityUpdater<EntityT, RequestT> {
    EntityT update(@MappingTarget EntityT entity, RequestT request);
}
