package so.sonya.muswebapp2.service.base;

import org.springframework.data.domain.Page;

public interface GenericPagingService<Response> {
    Page<Response> findAll(Integer pageNumber, Integer pageSize);
}
