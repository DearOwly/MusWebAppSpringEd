package so.sonya.muswebapp2.service;

public interface StandartService<DTO, ID> {
    DTO findById(ID id);
    ID save(DTO dto);
    void deleteById(ID id);
    DTO update(ID id, DTO dto);
}
