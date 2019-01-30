package fr.dauphine.miageif.msa.exemple;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction findByDate(Date date);
	Transaction findByType(String type);
    Transaction	findByIbansourAndIbandest(String ibansour, String ibandest);
}

