package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.PaymentDao;
import bo.edu.ucb.ingsoft.demorest.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentBl {
    @Autowired
    PaymentDao paymentDao;

    public Payment crearPayment(Payment payment){

        return paymentDao.crearPayment(payment);
    }

    public Payment findPaymentById(Integer id_payment) {
        return paymentDao.findPaymentById(id_payment);
    }

    public List<Payment> findAllPayment() {
        return paymentDao.findAllPayment();
    }

}
