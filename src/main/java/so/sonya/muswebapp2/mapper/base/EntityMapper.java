package so.sonya.muswebapp2.mapper.base;

public interface EntityMapper<EntityT, RequestT, ResponseT> {
    EntityT fromRequest(RequestT request);

    ResponseT toResponse(EntityT entity);
}
