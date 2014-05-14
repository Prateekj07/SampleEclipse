package mkyong;

import java.util.Date;

import org.hibernate.Session;


public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.save(stockDailyRecords);
        
        
        
        StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
        stockDailyRecords2.setPriceOpen(new Float("2.2"));
        stockDailyRecords2.setPriceClose(new Float("2.1"));
        stockDailyRecords2.setPriceChange(new Float("22.0"));
        stockDailyRecords2.setVolume(2000000L);
        stockDailyRecords2.setDate(new Date());
        
        stockDailyRecords2.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords2);

        session.save(stockDailyRecords2);
        

		session.getTransaction().commit();
		
		/*Stock s = (Stock) session.get(Stock.class, 1);
		System.out.println("S  :"+s);
		*/
		
		System.out.println("Done");
	}
}
