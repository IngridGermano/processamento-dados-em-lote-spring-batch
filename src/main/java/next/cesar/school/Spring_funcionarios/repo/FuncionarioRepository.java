package next.cesar.school.Spring_funcionarios.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import next.cesar.school.Spring_funcionarios.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Serializable> {

}
