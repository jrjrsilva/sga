package br.gov.ba.pm.sga.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sga.model.Demanda;
import br.gov.ba.pm.sga.model.Estoque;
import br.gov.ba.pm.sga.model.Grupo;
import br.gov.ba.pm.sga.model.Inventario;
import br.gov.ba.pm.sga.model.Inventariomp;
import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Pedido;
import br.gov.ba.pm.sga.model.Produto;
import br.gov.ba.pm.sga.repository.Movimentos;
import br.gov.ba.pm.sga.service.AlunoService;
import br.gov.ba.pm.sga.service.DemandaService;
import br.gov.ba.pm.sga.service.EstoqueService;
import br.gov.ba.pm.sga.service.InventarioService;
import br.gov.ba.pm.sga.service.InventariompService;
import br.gov.ba.pm.sga.service.PedidoService;
import br.gov.ba.pm.sga.service.ProdutoService;



@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "./";
    
    @Autowired
    private ServletContext context;
    
    @Autowired
    private AlunoService alunoService;
    
    
    @Autowired
    private InventarioService inventarioService;
    
    @Autowired
    private InventariompService inventariompService;
    
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DemandaService demandaService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private Movimentos movimentos;
	
	@GetMapping("/")
    public String index() {
        return "upload";
    }

   

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("tipoUpload") Integer tipoUpload,@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Selecione um arquivo!");
            return "redirect:/uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Adicionado o arquivo'" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
            
        if (tipoUpload == 1) {
        	carregarArquivo(file.getOriginalFilename());
        }else if(tipoUpload == 2){
        	carregarEstoque(file.getOriginalFilename());
        }else if(tipoUpload == 3) {
        	carregarDemanda(file.getOriginalFilename());
        }else if (tipoUpload == 4) {
        	carregarEstoqueDemanda(file.getOriginalFilename());
        }else if (tipoUpload == 5 ) {
        	carregarPedidosEstoque(file.getOriginalFilename());
        }else if(tipoUpload == 6) {
        	carregarGruposEstoque(file.getOriginalFilename());
        }else if(tipoUpload == 7) {
        	carregarInventariomp(file.getOriginalFilename());
        }else if(tipoUpload == -1) {
        //	carregarfatorRH(file.getOriginalFilename());
        }
        
        return "redirect:/uploadStatus";
    }

    private void carregarInventario(String arquivo) {
    	List<Inventario> carga = new ArrayList<Inventario>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Inventario inventario = new Inventario();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				inventario.setCodigo(linha.getCell(0).getStringCellValue());
    				inventario.setUnidade(linha.getCell(1).getStringCellValue());
    				inventario.setNome(linha.getCell(2).getStringCellValue());
    				inventario.setQuantidade((linha.getCell(3).getNumericCellValue()));
    				inventario.setAno("2017");
    				}
    			
    			carga.add(inventario);
    		}
    		carga.remove(0);
    	
    		for(Inventario p : carga){
    			inventarioService.salvar(p);
    			}
    			
    			
    		
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
    
    private void carregarInventariomp(String arquivo) {
    	List<Inventariomp> carga = new ArrayList<Inventariomp>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Inventariomp inventariomp = new Inventariomp();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				inventariomp.setCodigo(linha.getCell(0).getStringCellValue());
    				inventariomp.setUnidade(linha.getCell(1).getStringCellValue());
    				inventariomp.setNome(linha.getCell(2).getStringCellValue());
    				inventariomp.setQuantidade((linha.getCell(3).getNumericCellValue()));
    				inventariomp.setValor(linha.getCell(4).getNumericCellValue());
    				inventariomp.setAno("2015");
    				}
    			
    			carga.add(inventariomp);
    		}
    		carga.remove(0);
    	
    		for(Inventariomp p : carga){
    			inventariompService.salvar(p);
    			}
    			
    			
    		
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
  /*  
    private void carregarDatas() {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/y");
		
    	List<Aluno> carga = new ArrayList<Aluno>();
    	
    	try {
    		carga = alunoService.findAll();	
    		
    		for(Aluno p : carga){
    			String niver = p.getDtnasc();
        		Date data =  format.parse(niver);
        		 Calendar calendario = Calendar.getInstance();
        		 calendario.setTime(data);
        		 p.setNascimento(calendario.getTime());
        		 alunoService.salvar(p);
    		}	
    	} catch (Exception e) {
    		e.printStackTrace();
    	} 
	}
*/
    private void carregarInventariomp() {
    	List<Inventariomp> carga = new ArrayList<Inventariomp>();
    	String ano = "2017";
    	try {
    			
    		carga = inventariompService.obterPorAno(ano);	
    		
    		for(Inventariomp p : carga){
    			if(p.getQuantidade() == 0) {
    				int sort = 1+(int)(Math.random()* 27);
    				p.setQuantidade(new Double(sort));
    				inventariompService.salvar(p);
    			}
    		}	
    	} catch (Exception e) {
    		e.printStackTrace();
    	} 
	}


	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }  
    
    @GetMapping("/grafico")
    public String grafico() {
        return "grafico";
    } 

    public void carregarEstoqueNovo(String arquivo){
    	List<Produto> carga = new ArrayList<Produto>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Produto produto = new Produto();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				
    				produto.setCodigo(linha.getCell(0).getStringCellValue());
    				produto.setNome(linha.getCell(1).getStringCellValue());
    				produto.setQuantidade((linha.getCell(2).getNumericCellValue()));
    				produto.setEan(linha.getCell(3).getStringCellValue());
    				}
    			carga.add(produto);
    		}
    		carga.remove(0);
    		carga.remove(carga.size() - 1);
    		System.out.println(carga);
    		for (Produto pe : produtoService.getAllProdutos()) {
    			pe.setQuantidade((double) 0);
    			produtoService.salvar(pe);
    		}
    		
    		
    		for(Produto p : carga){
    			
    			Produto pb = new Produto();
    			pb = produtoService.buscar(p.getCodigo());
    			if (pb.getCodigo() != null){
    			
    				pb.setQuantidade((double) p.getQuantidade());
    				produtoService.salvar(pb);
    				
    				
    			}else {
    				
    				pb.setNome(p.getNome());
        			pb.setQuantidade(p.getQuantidade());
        			pb.setEan(p.getEan());
        			
        			produtoService.salvar(pb);
        			
    			}
    			Movimento mv = new Movimento();
    			
    			mv.setCodigo(p.getCodigo());
    			mv.setDataCadastro(new Date());
    			mv.setGrupo(pb.getGrupo());
    			mv.setNome(p.getNome());
    			mv.setQuantidade(p.getQuantidade());
    			mv.setTipo("S");
    			
    			this.movimentos.save(mv);
    				
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void carregarArquivo(String arquivo){
    	List<Produto> carga = new ArrayList<Produto>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Produto produto = new Produto();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				
    				produto.setCodigo(linha.getCell(0).getStringCellValue());
    				produto.setNome(linha.getCell(1).getStringCellValue());
    				produto.setQuantidade((linha.getCell(2).getNumericCellValue()));
    				}
    			carga.add(produto);
    		}
    		carga.remove(0);
    		carga.remove(carga.size() - 1);
    		System.out.println(carga);
    		
    		for(Produto p : carga){
    			
    			Produto pb = new Produto();
    			pb = produtoService.buscar(p.getCodigo());
    			if (pb.getCodigo() != null){
    				
    				Double quantidade = pb.getQuantidade() - p.getQuantidade();
    				pb.setQuantidade(quantidade);
    				produtoService.salvar(pb);
    				
    				Movimento mv = new Movimento();
        			
        			mv.setCodigo(p.getCodigo());
        			mv.setDataCadastro(new Date());
        			mv.setGrupo(pb.getGrupo());
        			mv.setNome(p.getNome());
        			mv.setQuantidade(p.getQuantidade());
        			mv.setTipo("S");
        			
        			this.movimentos.save(mv);
    			}
    				
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
        
    public void carregarEstoque(String arquivo){
    	List<Produto> carga = new ArrayList<Produto>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Produto produto = new Produto();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				produto.setCodigo(linha.getCell(0).getStringCellValue());
    				produto.setNome(linha.getCell(1).getStringCellValue());
    				produto.setQuantidade((linha.getCell(2).getNumericCellValue()));
    				produto.setEan(linha.getCell(3).getStringCellValue());
    				}
    			carga.add(produto);
    		}
    		carga.remove(0);
    	//	carga.remove(carga.size() - 1);
    		System.out.println(carga);
    		
    		for(Produto p : carga){
    		
    			Movimento mv = new Movimento();
    			
    			mv.setCodigo(p.getCodigo());
    			mv.setDataCadastro(new Date());
    			mv.setGrupo(p.getGrupo());
    			mv.setNome(p.getNome());
    			mv.setQuantidade(p.getQuantidade());
    			
    			produtoService.salvar(p);
    			
    			mv.setTipo("E");
    			
    			this.movimentos.save(mv);
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void carregarPedidosEstoque(String arquivo){
    	List<Pedido> carga = new ArrayList<Pedido>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Pedido pedido = new Pedido();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				pedido.setCodigo(linha.getCell(0).getStringCellValue());
    				pedido.setNome(linha.getCell(1).getStringCellValue());
    				pedido.setQuantidade((linha.getCell(2).getNumericCellValue()));
    				}
    			
    			carga.add(pedido);
    		}
    		carga.remove(0);
    	
    		for(Pedido p : carga){
    			Pedido p1 = pedidoService.buscar(p.getCodigo()); 
    			if(p1 != null) {
    				p1.setQuantidade(p.getQuantidade() + p1.getQuantidade());
    				pedidoService.salvar(p1);
    			}else {
    				pedidoService.salvar(p);
    			}
    			
    			
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    
    public void carregarGruposEstoque(String arquivo){
    	List<Pedido> carga = new ArrayList<Pedido>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Pedido pedido = new Pedido();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				pedido.setCodigo(linha.getCell(0).getStringCellValue());
    				pedido.setNome(linha.getCell(3).getStringCellValue());
    				}

    				carga.add(pedido);
    		}
    		carga.remove(0);
    	
    		for(Pedido p : carga){
    			if(!p.getCodigo().equals("")) {
    				Produto p1 = produtoService.buscar(p.getNome()); 
        			if(p1 != null) {
        				Grupo g = new Grupo();
        				g.setId(Long.valueOf(p.getCodigo()));
        				p1.setGrupo(g);
        				produtoService.salvar(p1);
        			}	
    			}
    			
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    public void carregarDemanda(String arquivo){
    	List<Demanda> carga = new ArrayList<Demanda>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Demanda demanda = new Demanda();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				demanda.setCodigo(linha.getCell(0).getStringCellValue());
    				demanda.setNome(linha.getCell(1).getStringCellValue());
    				demanda.setQuantidade(linha.getCell(2).getNumericCellValue());
    				}
    			carga.add(demanda);
    		}
    		carga.remove(0);
    	//	carga.remove(carga.size() - 1);
    		System.out.println(carga);
    		
    		for(Demanda p : carga){
    			if(!p.getCodigo().equals(""))
    				demandaService.salvar(p);
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
   
    public void carregarEstoqueDemanda(String arquivo){
    	List<Estoque> carga = new ArrayList<Estoque>();
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Estoque estoque = new Estoque();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				estoque.setCodigo(linha.getCell(0).getStringCellValue());
    				estoque.setNome(linha.getCell(1).getStringCellValue());
    				estoque.setQuantidade((linha.getCell(2).getNumericCellValue()));
    				
    				}
    			carga.add(estoque);
    		}
    		carga.remove(0);
    	//	carga.remove(carga.size() - 1);
    		System.out.println(carga);
    		
    		for(Estoque p : carga){		
    			estoqueService.salvar(p);
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
   
    
    public void carregarEstoqueOld(String arquivo){
    	List<Produto> carga = new ArrayList<Produto>();
    
    	try {
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Produto produto = new Produto();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				produto.setCodigo(linha.getCell(0).getStringCellValue());
    				produto.setNome(linha.getCell(1).getStringCellValue());
    				produto.setQuantidade((linha.getCell(2).getNumericCellValue()));
    				produto.setEan(linha.getCell(3).getStringCellValue());
    				}
    			carga.add(produto);
    		}
    		carga.remove(0);
    	//	carga.remove(carga.size() - 1);
    		System.out.println(carga);
    		
    		for(Produto p : carga){
    			produtoService.salvar(p);
    			
    			Movimento mv = new Movimento();
    			
    			mv.setCodigo(p.getCodigo());
    			mv.setDataCadastro(new Date());
    			mv.setGrupo(p.getGrupo());
    			mv.setNome(p.getNome());
    			mv.setQuantidade(p.getQuantidade());
    			mv.setTipo("E");
    			
    			this.movimentos.save(mv);
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void exportarInventario() {
    	String ano = "2017";
    	List<Inventario> saida = new ArrayList<Inventario>();
    	saida = inventarioService.obterPorAno(ano);
    	String nome = "Inventario"+ano;
    	String filename = context.getRealPath(nome+".xlsx");
    	try {
			FileOutputStream file = new FileOutputStream(new File(UPLOADED_FOLDER+nome+".xlsx"));
			
			Workbook wb = new HSSFWorkbook();
			
			Sheet planilha = wb.createSheet(nome);
			
			Row linha = planilha.createRow(0);
			
			Cell celula = linha.createCell(0);
			celula.setCellValue("Código");
			Cell celula1 = linha.createCell(1);
			celula1.setCellValue("Unidade");
			Cell celula2 = linha.createCell(2);
			celula2.setCellValue("Nome");
			Cell celula3 = linha.createCell(3);
			celula3.setCellValue("Quantidade");
			Cell celula4 = linha.createCell(4);
			celula4.setCellValue("Valor Unitario");
			Cell celula5 = linha.createCell(5);
			celula5.setCellValue("Valor Total");
			
			int linhas = 1;
			
			
			for (Iterator iterator = saida.iterator(); iterator.hasNext();) {
				Inventario inv = (Inventario) iterator.next();
				
					
				linha = planilha.createRow(linhas++);
				Cell cod = linha.createCell(0);
				cod.setCellValue(inv.getCodigo());
				Cell und = linha.createCell(1);
				und.setCellValue(inv.getUnidade());
				Cell nom = linha.createCell(2);
				nom.setCellValue(inv.getNome());
				Cell qtd = linha.createCell(3);
				if(inv.getQuantidade() > 20 && inv.getQuantidade() < 90) {
					qtd.setCellValue(Math.floor(inv.getQuantidade() /3));
					}else if(inv.getQuantidade() > 90 && inv.getQuantidade() < 210){
						qtd.setCellValue(Math.floor(inv.getQuantidade()/4));
					}else if(inv.getQuantidade() > 210 ) {
						qtd.setCellValue(Math.floor(inv.getQuantidade()/5));
					}else {
						qtd.setCellValue(inv.getQuantidade());
					}
				Cell vl = linha.createCell(4);
				vl.setCellValue(inv.getValor());
				Cell tot = linha.createCell(5);
				tot.setCellValue(0);
				
				
			}
			
			
			wb.write(file);
		
			file.close();
			
			System.out.println(nome);
			
			System.out.println(filename);
			
			
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
     
    public void exportarInventariomp() {
    	String ano = "2015";
    	List<Inventariomp> saida = new ArrayList<Inventariomp>();
    	saida = inventariompService.obterPorAno(ano);
    	String nome = "Inventariomp"+ano;
    	String filename = context.getRealPath(nome+".xlsx");
    	try {
			FileOutputStream file = new FileOutputStream(new File(UPLOADED_FOLDER+nome+".xlsx"));
			
			Workbook wb = new HSSFWorkbook();
			
			Sheet planilha = wb.createSheet(nome);
			
			Row linha = planilha.createRow(0);
			
			Cell celula = linha.createCell(0);
			celula.setCellValue("Código");
			Cell celula1 = linha.createCell(1);
			celula1.setCellValue("Unidade");
			Cell celula2 = linha.createCell(2);
			celula2.setCellValue("Nome");
			Cell celula3 = linha.createCell(3);
			celula3.setCellValue("Quantidade");
			Cell celula4 = linha.createCell(4);
			celula4.setCellValue("Valor Unitario");
			Cell celula5 = linha.createCell(5);
			celula5.setCellValue("Valor Total");
			
			int linhas = 1;
			
			for (Iterator iterator = saida.iterator(); iterator.hasNext();) {
				Inventariomp inv = (Inventariomp) iterator.next();
					
				linha = planilha.createRow(linhas++);
				Cell cod = linha.createCell(0);
				cod.setCellValue(inv.getCodigo());
				Cell und = linha.createCell(1);
				und.setCellValue(inv.getUnidade());
				Cell nom = linha.createCell(2);
				nom.setCellValue(inv.getNome());
				Cell qtd = linha.createCell(3);
				if(inv.getQuantidade() > 1 && inv.getQuantidade() < 100) {
					qtd.setCellValue(Math.floor(inv.getQuantidade() /2));
					}else if(inv.getQuantidade() > 100 && inv.getQuantidade() < 200){
						qtd.setCellValue(Math.floor(inv.getQuantidade()/3));
					}else if(inv.getQuantidade() > 200 ) {
						qtd.setCellValue(Math.floor(inv.getQuantidade()/4));
					}else {
						qtd.setCellValue(inv.getQuantidade());
					}
				Cell vl = linha.createCell(4);
				vl.setCellValue(inv.getValor());
				Cell tot = linha.createCell(5);
				tot.setCellValue(0);	
				
			}
			
			
			wb.write(file);
		
			file.close();
			
			System.out.println(nome);
			
			System.out.println(filename);
			
			
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
/*    
    
    public void carregarfatorRH(String arquivo){
    	List<Aluno> carga = new ArrayList<Aluno>();
    	List<String> cargas = new ArrayList<String>();
    	try {
    		cargas = alunoService.matriculas();
    		FileInputStream fileInputStream = new FileInputStream(UPLOADED_FOLDER + arquivo);
    		XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    		
    		XSSFSheet planilha = wb.getSheetAt(0);
    		
    		Iterator<Row> linhas = planilha.iterator();
    		while(linhas.hasNext()){
    			Aluno aluno = new Aluno();
    			
    			Row linha = linhas.next();
    			
    			if (linha.getRowNum() > 0 ){
    				
    				if(cargas.contains(linha.getCell(0).getStringCellValue())) {
    					aluno = alunoService.buscar(linha.getCell(0).getStringCellValue());
    					//System.out.println(aluno.getNome());
    						
    					aluno.setFatorrh((linha.getCell(2)!= null ) ? linha.getCell(2).getStringCellValue() : "NI");
    					aluno.setGruposanguineo((linha.getCell(1) != null) ? linha.getCell(1).getStringCellValue() : "NI");
    					alunoService.salvar(aluno);
    					
    				}
    			}
    			
    		}
    	
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
*/    
  /*  public static void download(byte[] arquivo, String filename, String mimeType) { 
	 	HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	 	response.addHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setContentLength(arquivo.length);
        try {
            response.setContentType(mimeType);
            response.getOutputStream().write(arquivo);
            response.getOutputStream().flush();
            FacesContext.getCurrentInstance().responseComplete();
        }catch (Exception e) {
	}
    }*/
    
    
}