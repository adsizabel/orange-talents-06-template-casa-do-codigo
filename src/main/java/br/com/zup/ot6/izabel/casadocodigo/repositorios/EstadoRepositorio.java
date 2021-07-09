package br.com.zup.ot6.izabel.casadocodigo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zup.ot6.izabel.casadocodigo.entidades.Estado;

public interface EstadoRepositorio extends JpaRepository<Estado, Long> {
	
	@Query("select e from Estado e where e.pais.id = :idPais")
	public List<Estado> pesquisaPaises(Long idPais);

}
