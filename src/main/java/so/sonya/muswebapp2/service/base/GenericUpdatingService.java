package so.sonya.muswebapp2.service.base;

public interface GenericUpdatingService<Id, Request, Response> {
    Response update(Id id, Request request);
}
