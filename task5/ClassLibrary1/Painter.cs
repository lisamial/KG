using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Windows.Forms;

namespace Task5
{
    public class Painter
    {
        private Bitmap bitmap;
        private Graphics gr;
        private Sprites sprites;
        private PictureBox panel;

        public Painter(Bitmap map)
        {
            bitmap = map;
            gr = Graphics.FromImage(map);
            sprites = new Sprites();
        }
        public Painter(PictureBox panel)
        {
            this.panel = panel;
            this.bitmap = new Bitmap(panel.Width, panel.Height);
            this.gr = Graphics.FromImage(bitmap);
            sprites = new Sprites();
        }

        public Bitmap Paint()
        {
            gr.Clear(Color.Transparent);
            int step = 0;
            for (int i = 0; step < panel.Width; i++)
            {
                gr.DrawImage(sprites.Fire.Sprite, step, 250);
                sprites.Fire.Update();
                step += 100;
            }
            gr.DrawImage(sprites.CatInCup.Sprite, sprites.CatInCup.X, 180, 105, 160);
            sprites.CatInCup.Update();
            if (sprites.CatInCup.X < -10)
            {
                sprites.CatInCup.X = panel.Width +100;
            }
            else
            {
                sprites.CatInCup.X -= 15;
            }

            gr.DrawLine(new Pen(Color.Black, 8), 0, 70, panel.Width, 70);
            gr.DrawString("Mmmmm....Hi :)", new Font("Nightclub BTN", 16), Brushes.Gray, panel.Width / 2 - 70, 90) ;
            if (sprites.CatWalk.X > panel.Width)
            {
                sprites.CatWalk.X = -90;
            } else
            {
                sprites.CatWalk.X += 10;

            }
            if (sprites.CatWalk2.X > panel.Width)
            {
                sprites.CatWalk2.X = -10;
            } else
            {
                sprites.CatWalk2.X += 20;
            }
            if (sprites.CatWalk3.X > panel.Width)
            {
                sprites.CatWalk3.X = -100;
            } else
            {
                sprites.CatWalk3.X += 5;
            }
            gr.DrawImage(sprites.CatWalk.Sprite, sprites.CatWalk.X, 10, 90, 60);
            gr.DrawImage(sprites.CatWalk2.Sprite, sprites.CatWalk2.X, 10, 90, 60);
            gr.DrawImage(sprites.CatWalk3.Sprite, sprites.CatWalk3.X, 10, 90, 60);
            sprites.CatWalk.Update();
            sprites.CatWalk2.Update();
            sprites.CatWalk3.Update();

            return bitmap;
        }

    }
}
