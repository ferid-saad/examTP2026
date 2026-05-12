import 'package:flutter/material.dart';
import '../models/categorie.dart';
import '../models/produit.dart';
import '../services/api_service.dart';
import 'avis_screen.dart';

class ProduitsScreen extends StatelessWidget {
  final Categorie categorie;

  const ProduitsScreen({super.key, required this.categorie});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(categorie.nom),
        backgroundColor: Colors.indigo,
        foregroundColor: Colors.white,
      ),
      body: FutureBuilder<List<Produit>>(
        future: ApiService.getProduitsByCategorie(categorie.id),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (snapshot.hasError) {
            return Center(child: Text('Erreur : ${snapshot.error}'));
          }
          final produits = snapshot.data!;
          if (produits.isEmpty) {
            return const Center(child: Text('Aucun produit trouvé'));
          }
          return ListView.builder(
            itemCount: produits.length,
            itemBuilder: (context, index) {
              final produit = produits[index];
              return Card(
                margin: const EdgeInsets.symmetric(
                    horizontal: 12, vertical: 6),
                child: ListTile(
                  title: Text(produit.nom),
                  subtitle: Text('Prix : ${produit.prix} TND'),
                  trailing: Text('Stock : ${produit.stock}'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (_) => AvisScreen(produit: produit),
                      ),
                    );
                  },
                ),
              );
            },
          );
        },
      ),
    );
  }
}