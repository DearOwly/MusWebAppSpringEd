package so.sonya.muswebapp2.mapper.base;

public interface GenericMapper<Entity, Request, Response> {
    Entity toEntity(Request request);

    Response toResponse(Entity entity);
}
