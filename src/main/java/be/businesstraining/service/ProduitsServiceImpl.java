//package be.businesstraining.service;
//
//import be.businesstraining.domain.Offre;
//import be.businesstraining.repository.GamesRepository;
//import be.businesstraining.repository.ProduitsRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//public class ProduitsServiceImpl implements  ProduitsService {
//
//    private GamesRepository offresRepository;
//    private ProduitsRepository produitsRepository;
//
//    public ProduitsServiceImpl(GamesRepository offresRepository,
//                               ProduitsRepository produitsRepository ) {
//        this.offresRepository = offresRepository;
//        this.produitsRepository = produitsRepository;
//    }
//    @Override
//    public Set<Offre> toutesLesOffresParProduit(Long idProduit) {
//        return offresRepository.findAllByProduit_Id(idProduit);
//    }
//}
