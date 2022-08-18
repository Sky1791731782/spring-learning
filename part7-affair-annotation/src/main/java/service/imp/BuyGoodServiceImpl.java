package service.imp;

import dao.GoodsDao;
import dao.SaleDao;
import domain.Goods;
import domain.Sale;
import exception.NotEnoughException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.BuyGoodService;

/**
 * @author yqb
 * @Date 2022/8/17 16:47
 */
public class BuyGoodServiceImpl implements BuyGoodService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    /*@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class, NotEnoughException.class
            }
    )*/
/**
 * @author yqb
 * 代码等同于@Transactional
 * rollbackFor: 表示发生指定异常一定回滚
 * 处理逻辑:
 *          1）spring框架在运行时会先检查方法抛出的异常是不是在 rollbackFor的属性列表中，
 *          如果在不管是什么类型的异常都会回滚
 *          2）如果不在列表中spring会判断是不是RunTimeException，如果是一定回滚，
 */
    @Transactional
    @Override
    public void buy(int goodsid, int num) {
        //记录销售信息，向sale添加记录
        Sale sale = new Sale();
        sale.setGid(goodsid);
        sale.setNums(num);
        saleDao.insertSale(sale);
        //更新库存
        Goods goods = goodsDao.selectGoods(goodsid);
        if (goods == null) {
            throw new NullPointerException("商品不存在");
        } else if (num > goods.getAmount()) {
            throw new NotEnoughException("库存不足！");
        }
        Goods buygoods = new Goods();
        buygoods.setId(goodsid);
        buygoods.setAmount(num);
        goodsDao.updateGoods(buygoods);
    }
}