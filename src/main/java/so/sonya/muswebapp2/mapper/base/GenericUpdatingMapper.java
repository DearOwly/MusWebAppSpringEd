package so.sonya.muswebapp2.mapper.base;

import org.mapstruct.MappingTarget;

public interface GenericUpdatingMapper<Entity, CreateRequest, UpdateRequest, Response> extends GenericMapper<Entity, CreateRequest, Response> {
    Entity update(@MappingTarget Entity entity, UpdateRequest request);
}
