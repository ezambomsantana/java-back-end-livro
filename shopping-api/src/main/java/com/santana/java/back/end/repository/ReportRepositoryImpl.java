package com.santana.java.back.end.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.santana.java.back.end.model.Shop;

public class ReportRepositoryImpl implements ReportRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Integer valorMinimo) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from shop sp where sp.date >= :dataInicio ");

		if (dataFim != null) {
			sb.append("and sp.date <= :dataFim ");			
		}

		if (valorMinimo != null) {
			sb.append("and sp.total <= :valorMinimo ");			
		}
		
		Query query = entityManager.createNativeQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);

		if (dataFim != null) {
			query.setParameter("dataFim", dataFim);			
		}

		if (valorMinimo != null) {
			query.setParameter("valorMinimo", valorMinimo);	
		}
		return query.getResultList();
		
	}

	@Override
	public List<Shop> getReportByDate(Date dataInicio, Date dataFim) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*), sum(tota), avg(total from shop sp where ");
		sb.append("sp.date >= :dataInicio ");
		sb.append("and sp.date <= :dataFim ");		
		
		Query query = entityManager.createNativeQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);			

		return query.getResultList();
	}

}
