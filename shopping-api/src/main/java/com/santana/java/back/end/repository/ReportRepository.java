package com.santana.java.back.end.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.santana.java.back.end.dto.ShopReportDTO;
import com.santana.java.back.end.model.Shop;

public interface ReportRepository  {
	
	List<Shop> getShopByFilters(LocalDateTime dataInicio, LocalDateTime dataFim, Float valorMinimo);
	
	ShopReportDTO getReportByDate(LocalDateTime dataInicio, LocalDateTime dataFim);

}
