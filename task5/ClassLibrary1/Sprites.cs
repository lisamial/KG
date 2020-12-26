using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Task5

{
    public class Sprites
    {
        public Picture CatInCup { get; protected set; }
        public Picture Fire { get; protected set; }
        public Picture CatWalk { get; protected set; }
        public Picture CatWalk2 { get; protected set; }
        public Picture CatWalk3 { get; protected set; }
        private string path;

        public Sprites()
        {
            path = new FileInfo(Directory.GetCurrentDirectory()).Directory.Parent.
                            Parent.Parent.FullName + "\\ClassLibrary1\\Texture";
            MakeCat();
            MakeFire();
            MakeCatWalk();
        }


        private void MakeCat()
        {
            Image[] images = new Image[16];
            for (int i = 0; i < 16; i++)
            {
                images[i] = Image.FromFile(path + $"\\animCat\\1x\\{i}.png");
            }
            CatInCup = new Picture(images);
            CatInCup.X = 100;
        }

        private void MakeFire()
        {
            Image[] images = new Image[5];
            for(int i = 1; i < 6; i++)
            {
                images[i-1] = Image.FromFile(path + $"\\animFire\\1x\\{i}.png");
            }
            Fire = new Picture(images);
        }

        private void MakeCatWalk()
        {
            Image[] images = new Image[12];
            for (int i = 0; i < 12; i++)
            {
                images[i] = Image.FromFile(path + $"\\animWalkCat\\60h\\{i}.png");
            }
            CatWalk = new Picture(images);
            CatWalk2 = new Picture(images);
            CatWalk3 = new Picture(images);
            CatWalk.X = 0;
            CatWalk2.X = 100;
            CatWalk3.X = 200;
        }
       
    }
}
