package com.sitarski.decertoapp.repository.boundary;


import com.sitarski.decertoapp.repository.entity.NumRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRecordRepository extends JpaRepository<NumRecord,Long> {


}
