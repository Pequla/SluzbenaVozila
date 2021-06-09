package com.pequla.api.repository;

import com.pequla.api.entity.Zaposleni;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaposleniRepository extends CrudRepository<Zaposleni, Integer> {

    //Pretaraga po imenu
    Zaposleni findOneByImeIgnoreCase(String ime);

    //Pretraga po prezimenu
    Zaposleni findOneByPrezimeIgnoreCase(String prezime);

    //Pretraga po jmbg
    Zaposleni findOneByJmbg(String jmbg);
}
