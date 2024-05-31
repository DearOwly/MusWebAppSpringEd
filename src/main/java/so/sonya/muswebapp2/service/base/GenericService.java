package so.sonya.muswebapp2.service.base;

public interface GenericService<Id, Request, Response> {
    Response findById(Id id);

    Response save(Request request);

    void deleteById(Id id);
}
