package br.com.janainadias.pessoaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.janainadias.pessoaservice.model.PessoaModel;
import br.com.janainadias.pessoaservice.model.ResponseModel;
import br.com.janainadias.pessoaservice.repository.PessoaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(value="/pessoa", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody PessoaModel pessoa){
		
		try {
			
			this.pessoaRepository.save(pessoa);
			
			return new ResponseModel(1, "Registro Salvo com sucesso!");
			
		} catch (Exception e) {
			
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/pessoa", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody PessoaModel pessoa){
		
		try {
			
			this.pessoaRepository.save(pessoa);
			
			return new ResponseModel(1, "Registro atualizado com sucesso!");
			
		} catch (Exception e) {
			
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/pessoa", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<PessoaModel> consultar(){
		
		return this.pessoaRepository.findAll();
	}
	

	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
		
		PessoaModel pessoaModel = pessoaRepository.findById(codigo);
		
		try {
			
			pessoaRepository.delete(pessoaModel);
			
			return new ResponseModel(1,"Registro Excluído com sucesso!");
			
		} catch (Exception e) {
			
			return new ResponseModel(0, e.getMessage());
		}
		
	}

}
