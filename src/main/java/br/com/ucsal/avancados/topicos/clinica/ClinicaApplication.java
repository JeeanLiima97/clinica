package br.com.ucsal.avancados.topicos.clinica;

import br.com.ucsal.avancados.topicos.clinica.domain.entity.*;
import br.com.ucsal.avancados.topicos.clinica.domain.entity.Enum.TipoExame;
import br.com.ucsal.avancados.topicos.clinica.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaApplication implements CommandLineRunner {

	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ExameRepository exameRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
//	@Autowired
//	private ClinicaRepository clinicaRepository;


	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Clinica clinica = new Clinica();
//		clinica.setNome("Aloha");
//
//		Empresa empresa = new Empresa();
//		empresa.setNome("Ucsal");
//		empresa.setClinica(clinica);
//		empresa.setCnpj("CNPJ");
//
//
//
//		Funcionario f1 = new Funcionario();
//		f1.setNome("Jean");
//		f1.setMatricula(1231);
//		f1.setEmpresa(empresa);
//
//		Medico medico = new Medico();
//		medico.setClinica(clinica);
//		medico.setNome("Jean Medico");
//		medico.setCrm("3123213");
//
//		Exame exame = new Exame();
//		exame.setFuncionario(f1);
//		exame.setMedico(medico);
//		exame.setTipoExame(TipoExame.ADMISSIONAL);
//
//
//		clinicaRepository.save(clinica);
//		empresaRepository.save(empresa);
//		funcionarioRepository.save(f1);
//		medicoRepository.save(medico);
//		exameRepository.save(exame);




	}
}
