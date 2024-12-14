package iuh.fit.vomanhhieu_21097401_lab5week;

import com.neovisionaries.i18n.CountryCode;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.Role;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillType;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Account;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Address;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Skill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.AccountRepository;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.AddressRepository;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.CandidateRepository;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.SkillRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class VoManhHieu21097401Lab5WeekApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VoManhHieu21097401Lab5WeekApplication.class, args);
    }

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public void run(String... args) throws Exception {
//        Random rnd = new Random();
//        for(int i = 0 ; i < 500 ; i++) {
//            Address add = new Address();
//            add.setCity("HCM");
//            add.setStreet("Quang Trung");
//            add.setNumber(rnd.nextLong(1, 1000) + "");
//            add.setZipcode(rnd.nextLong(70000, 80000) + "");
//            add.setCountry(Short.parseShort((CountryCode.VN).getNumeric() + ""));
//            addressRepository.save(add);
//
//            Account acc = new Account("Name" + i, "password" + i, Role.CANDIDATE);
//            accountRepository.save(acc);
//
//            Candidate can = new Candidate();
//            can.setDob(LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)));
//            can.setFullName("Name #" + i);
//            can.setEmail("Name#"+"email_"+i+"@gmail.com");
//            can.setPhone(rnd.nextLong(1111111111L,9999999999L)+"");
//            can.setAddress(add);
//            can.setAccount(acc);
//            candidateRepository.save(can);
//        }
//        Faker faker = new Faker();
//        Random random = new Random();
//        for(int i = 0; i < 50 ; i++) {
//            SkillType type = null;
//            int value = random.nextInt(1,3);
//            switch (value) {
//                case 1: {
//                    type = SkillType.SOFT_SKILL;
//                    break;
//                }
//                case 2: {
//                    type = SkillType.TECHNICAL_SKILL;
//                    break;
//                }
//                case 3: {
//                    type = SkillType.UNSPECIFIC;
//                    break;
//                }
//            }
//            Skill s = new Skill("Description " + i, faker.job().keySkills(), type);
//            skillRepository.save(s);
//        }
    }
}
