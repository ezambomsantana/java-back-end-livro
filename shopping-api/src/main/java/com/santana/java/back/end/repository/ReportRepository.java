package com.santana.java.back.end.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.santana.java.back.end.dto.ShopReportDTO;
import com.santana.java.back.end.model.Shop;

public interface ReportRepository  {
	
	List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo);
	
	ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim);

}
