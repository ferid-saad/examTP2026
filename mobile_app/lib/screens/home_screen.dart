import 'package:flutter/material.dart';
import '../models/categorie.dart';
import '../services/api_service.dart';
import 'produits_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  Categorie? selectedCategorie;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Boutique'),
        backgroundColor: Colors.indigo,
        foregroundColor: Colors.white,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text(
              'Sélectionnez une catégorie',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            FutureBuilder<List<Categorie>>(
              future: ApiService.getCategories(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return const CircularProgressIndicator();
                }
                if (snapshot.hasError) {
                  return Text('Erreur : ${snapshot.error}');
                }
                final categories = snapshot.data!;
                return DropdownButton<Categorie>(
                  isExpanded: true,
                  hint: const Text('Choisir une catégorie'),
                  value: selectedCategorie,
                  items: categories.map((cat) {
                    return DropdownMenuItem<Categorie>(
                      value: cat,
                      child: Text(cat.nom),
                    );
                  }).toList(),
                  onChanged: (cat) {
                    setState(() => selectedCategorie = cat);
                  },
                );
              },
            ),
            const SizedBox(height: 24),
            if (selectedCategorie != null)
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.indigo,
                  foregroundColor: Colors.white,
                  minimumSize: const Size(double.infinity, 48),
                ),
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (_) => ProduitsScreen(
                        categorie: selectedCategorie!,
                      ),
                    ),
                  );
                },
                child: const Text('Voir les produits'),
              ),
          ],
        ),
      ),
    );
  }
}