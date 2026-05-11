package pa.parcial2.service.implementacion;

import pa.parcial2.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void enviarCorreoRegistro(String destino, String nombre) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destino);
        message.setSubject("Registro Exitoso Triatlón");
        message.setText("Hola " + nombre + ", tu registro fue exitoso.");
        mailSender.send(message);
    }
}
