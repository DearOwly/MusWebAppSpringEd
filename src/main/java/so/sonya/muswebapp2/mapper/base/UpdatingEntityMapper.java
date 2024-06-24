package so.sonya.muswebapp2.mapper.base;

public interface UpdatingEntityMapper<EntityT, CreateRequestT, UpdateRequestT, ResponseT>
    extends EntityMapper<EntityT, CreateRequestT, ResponseT>,
            EntityUpdater<EntityT, UpdateRequestT> {}
